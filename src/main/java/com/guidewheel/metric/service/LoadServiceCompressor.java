package com.guidewheel.metric.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidewheel.metric.model.Device;
import com.guidewheel.metric.model.LoadProcess;
import com.guidewheel.metric.model.Metric;
import com.guidewheel.metric.model.MetricDevice;
import com.guidewheel.metric.repository.DeviceRepository;
import com.guidewheel.metric.repository.LoadProcessRepository;
import com.guidewheel.metric.repository.MetricDeviceRepository;
import com.guidewheel.metric.repository.MetricRepository;

@Service
public class LoadServiceCompressor implements LoadService {

	@Autowired
	private MetricDeviceRepository metricDeviceRepository;
	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	private LoadProcessRepository lpRepository;
	@Autowired
	private ProcessService ps;

	public LoadProcess load(String pathFile, String idDevice) throws Exception {

		Device device = this.deviceRepository.findById(idDevice).get();
		LoadProcess loadprocess = lpRepository.save(new LoadProcess(device));
		new Thread(() -> {
			Path path = Paths.get(pathFile);
			final List<MetricDevice> metricList = new ArrayList();
			Stream<String> lines = null;
			try {
				lines = Files.lines(path);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			lines.parallel().forEach(d ->

			{
				try {

					// System.out.println(d);
					String[] val = d.split(",");

					Optional<Metric> metric = metricRepository.findById(val[1]);

					if (metric.isPresent() && metric.get().getSaveMetric()) {
						metricList
								.add(new MetricDevice(metric.get(), device,
										LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(val[0])),
												TimeZone.getDefault().toZoneId()),
										new BigDecimal(val[4]), loadprocess));
					}

				} catch (Exception e) {

					e.printStackTrace();
				}

			});

			loadprocess.setStatus("Inserting");
			loadprocess.setMetricQuantity(Long.valueOf(metricList.size()));
			this.lpRepository.save(loadprocess);
			metricDeviceRepository.saveAll(metricList);
			loadprocess.setStatus("Conciliating");
			ps.Process(loadprocess, idDevice);
		}).start();

		return loadprocess;
	}

}

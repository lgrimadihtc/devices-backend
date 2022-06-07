package com.guidewheel.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guidewheel.metric.model.Device;
import com.guidewheel.metric.model.DeviceStatus;
import com.guidewheel.metric.model.Metric;
import com.guidewheel.metric.repository.DeviceRepository;
import com.guidewheel.metric.repository.DeviceStatusRepository;
import com.guidewheel.metric.repository.MetricDeviceRepository;
import com.guidewheel.metric.repository.MetricRepository;

@SpringBootApplication
public class GuidewheelApplication implements CommandLineRunner {

	@Autowired
	private MetricDeviceRepository metricDeviceRepository;
	@Autowired
	private MetricRepository metricRepository;

	@Autowired
	private DeviceStatusRepository deviceStatusRepository;

	@Autowired
	private DeviceRepository dv;

	public static void main(String[] args) {
		SpringApplication.run(GuidewheelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Device device = dv.save(new Device("demo_ca1_t_axm", "Compressor generico ",
				"assets/img/devices/compressor01.jpg", 30, "Psum_kW"));

		Metric metric = metricRepository.save(new Metric("Psum_kW", "Psum_kW", Boolean.TRUE));

		this.deviceStatusRepository.save(new DeviceStatus(metric, device, "on-unloaded", 0.01, 1.0, Boolean.FALSE));
		this.deviceStatusRepository.save(new DeviceStatus(metric, device, "on-idle", 1.0, 20.984, Boolean.FALSE));
		this.deviceStatusRepository.save(new DeviceStatus(metric, device, "on-loaded", 20.984, 110.00, Boolean.FALSE));
		this.deviceStatusRepository.save(new DeviceStatus(metric, device, "off", 100000.00, 1000000.0, Boolean.TRUE));
	
		this.metricRepository.save(new Metric("PF1", "PF1", Boolean.TRUE));
		this.metricRepository.save(new Metric("PF2", "PF2", Boolean.TRUE));
		this.metricRepository.save(new Metric("PF3", "PF3", Boolean.TRUE));

	}

}

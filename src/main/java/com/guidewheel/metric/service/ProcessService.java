package com.guidewheel.metric.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidewheel.metric.model.DailyStatusSumary;
import com.guidewheel.metric.model.Device;
import com.guidewheel.metric.model.DeviceStatus;
import com.guidewheel.metric.model.LoadProcess;
import com.guidewheel.metric.repository.DailyStatusSumaryRepository;
import com.guidewheel.metric.repository.DeviceRepository;
import com.guidewheel.metric.repository.DeviceStatusRepository;
import com.guidewheel.metric.repository.MetricDeviceRepository;
import com.guidewheel.metric.repository.MetricRepository;

@Service
public class ProcessService {

	@Autowired
	private DeviceStatusRepository deviceStatusRepository;
	@Autowired
	private DailyStatusSumaryRepository dailyStatusSumaryRepository;

	@Autowired
	private MetricDeviceRepository metricDeviceRepository;

	@Autowired
	private MetricRepository metricRepository;

	@Autowired
	private DeviceRepository devicesRepository;

	public void Process(LoadProcess loadProcess, String idDevice) {

		Device device = this.devicesRepository.findById(idDevice).get();
		List<DeviceStatus> listStatus = this.deviceStatusRepository.findByDeviceDeviceIdOrderByMinValAsc(idDevice);

		LocalDate initDate = this.metricDeviceRepository.minDate(idDevice, loadProcess.getId()).toLocalDate();

		LocalDate endDate = this.metricDeviceRepository.maxDate(idDevice, loadProcess.getId()).toLocalDate().plusDays(1);
		Long dailyTotal;
		do {
			dailyTotal = 0L;
			for (int i = 0; i < listStatus.size(); i++) {

				if (!listStatus.get(i).getNoMetricStatus()) {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					Long val = this.metricDeviceRepository.statusCount(idDevice, loadProcess.getId(),
							LocalDateTime.of(initDate, LocalTime.ofSecondOfDay(0)),
							LocalDateTime.of(initDate, LocalTime.ofSecondOfDay(86399)),
							BigDecimal.valueOf(listStatus.get(i).getMinVal()),
							BigDecimal.valueOf(listStatus.get(i).getMaxVal()), device.getEnergyMetric()

					);

					dailyStatusSumaryRepository
							.save(new DailyStatusSumary(this.metricRepository.findById(device.getEnergyMetric()).get(),
									device, listStatus.get(i), val, val * device.getMetricEvery(), initDate));
					dailyTotal = dailyTotal + val;
				} else {
					System.out.println("####################################");
					Long offMetric = device.getExpectedMetricByDay() - dailyTotal;
					offMetric=offMetric<0?0L:offMetric;
					dailyStatusSumaryRepository.save(new DailyStatusSumary(
							this.metricRepository.findById(device.getEnergyMetric()).get(), device, listStatus.get(i),
							offMetric, offMetric * device.getMetricEvery(), initDate));
				}

			}
			initDate = initDate.plusDays(1);
		} while (initDate.isBefore(endDate));

	}

}

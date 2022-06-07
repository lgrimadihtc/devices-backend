package com.guidewheel.metric.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidewheel.metric.model.dto.Statistics;
import com.guidewheel.metric.model.dto.SummaryMetric;
import com.guidewheel.metric.repository.DailyStatusSumaryRepository;
import com.guidewheel.metric.repository.DeviceRepository;
import com.guidewheel.metric.repository.DeviceStatusRepository;
import com.guidewheel.metric.repository.MetricDeviceRepository;
import com.guidewheel.metric.repository.MetricRepository;

@Service
public class StatisticsService {
	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
	private MetricRepository metricRepository;

	@Autowired
	private DailyStatusSumaryRepository dailyStatusSumaryRepository;

	@Autowired
	private MetricDeviceRepository metricDeviceRepository;

	@Autowired
	private DeviceStatusRepository deviceStatusRepository;

	public Statistics getStatisticStatistics() {

		return new Statistics(this.deviceRepository.count(), this.metricRepository.count(),
				this.metricDeviceRepository.count(), this.dailyStatusSumaryRepository.count());
	}

	public List<SummaryMetric> getSummaryMetric() {
		
		List<SummaryMetric> summary=new ArrayList<>();
		
		
		deviceStatusRepository.findAll().forEach(
				item-> {
					
					summary.add(new SummaryMetric
							(item.getStatus(),dailyStatusSumaryRepository.sumByDeviceStatus(item.getId()) ));
				}
				);
		
		
		
		
	return summary;
	}
}
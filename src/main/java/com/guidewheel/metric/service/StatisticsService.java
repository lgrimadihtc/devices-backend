package com.guidewheel.metric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidewheel.metric.model.dto.Statistics;
import com.guidewheel.metric.repository.DailyStatusSumaryRepository;
import com.guidewheel.metric.repository.DeviceRepository;
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

	public Statistics getStatisticStatistics() {
		
		
		return new Statistics(this.deviceRepository.count(),this.metricRepository.count(),
				this.metricDeviceRepository.count(),this.dailyStatusSumaryRepository.count());
	}
}/*
private Long totalMetricDevices;
private Long totalDaily;*/
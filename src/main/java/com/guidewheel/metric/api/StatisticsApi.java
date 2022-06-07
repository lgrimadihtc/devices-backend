package com.guidewheel.metric.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guidewheel.metric.model.dto.Statistics;
import com.guidewheel.metric.service.StatisticsService;
@CrossOrigin
@RestController("/api/v1/")
public class StatisticsApi {
	
	@Autowired
	private StatisticsService statisticsService;
	@GetMapping("/statistic")
	public Statistics getApi() {
		
		
		return statisticsService.getStatisticStatistics();
	}

}

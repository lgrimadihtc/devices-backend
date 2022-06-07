package com.guidewheel.metric.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guidewheel.metric.model.dto.Statistics;
import com.guidewheel.metric.model.dto.SummaryMetric;
import com.guidewheel.metric.service.StatisticsService;
@CrossOrigin
@RestController("/api/v1/")
public class StatisticsApi {
	
	@Autowired
	private StatisticsService statisticsService;
	@GetMapping("/statistic")
	public ResponseEntity<Statistics> getStatistics() {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(this.statisticsService.getStatisticStatistics());
	}
	
	@GetMapping("/summarymetric")
	public  ResponseEntity<List<SummaryMetric>> getSummaryMetric() {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(this.statisticsService.getSummaryMetric());
	}
	
	

}

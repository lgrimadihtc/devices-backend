package com.guidewheel.metric.model.dto;

public class Statistics {

	private Long totalDevices;
	private Long totalMetric;
	private Long totalMetricDevices;
	private Long totalDaily;



	public Statistics(Long totalDevices, Long totalMetric, Long totalMetricDevices, Long totalDaily) {
		super();
		this.totalDevices = totalDevices;
		this.totalMetric = totalMetric;
		this.totalMetricDevices = totalMetricDevices;
		this.totalDaily = totalDaily;
	}
	

	public Long getTotalMetricDevices() {
		return totalMetricDevices;
	}

	public void setTotalMetricDevices(Long totalMetricDevices) {
		this.totalMetricDevices = totalMetricDevices;
	}

	public Long getTotalDaily() {
		return totalDaily;
	}

	public void setTotalDaily(Long totalDaily) {
		this.totalDaily = totalDaily;
	}

	public Long getTotalDevices() {
		return totalDevices;
	}

	public void setTotalDevices(Long totalDevices) {
		this.totalDevices = totalDevices;
	}

	public Long getTotalMetric() {
		return totalMetric;
	}

	public void setTotalMetric(Long totalMetric) {
		this.totalMetric = totalMetric;
	}

}

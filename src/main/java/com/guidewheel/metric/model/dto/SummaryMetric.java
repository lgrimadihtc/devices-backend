package com.guidewheel.metric.model.dto;

public class SummaryMetric {

	private String metric;
	private Long totalMetrics;
	public String getMetric() {
		return metric;
	}
	public void setMetric(String metric) {
		this.metric = metric;
	}
	public Long getTotalMetrics() {
		return totalMetrics;
	}
	public void setTotalMetrics(Long totalMetrics) {
		this.totalMetrics = totalMetrics;
	}
	public SummaryMetric(String metric, Long totalMetrics) {
		super();
		this.metric = metric;
		this.totalMetrics = totalMetrics;
	}
	

}

package com.guidewheel.metric.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Metric {
	@Id
	private String metricId;
	
	private String description;
	private Boolean saveMetric;
	public Metric() {
		super();
	}

	public String getMetricId() {
		return metricId;
	}

	public void setMetricId(String metricId) {
		this.metricId = metricId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Metric(String metricId, String description,Boolean saveMetric) {
		super();
		this.metricId = metricId;
		this.description = description;
		this.saveMetric=saveMetric;
	}

	public Boolean getSaveMetric() {
		return saveMetric;
	}

	public void setSaveMetric(Boolean saveMetric) {
		this.saveMetric = saveMetric;
	}
	
	
}

package com.guidewheel.metric.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "METRIC_DEVICE")
public class MetricDevice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "METRIC_ID")
	private Metric metric;
	@ManyToOne
	@JoinColumn(name = "DEVICE_ID")
	private Device device;
	
	@ManyToOne
	@JoinColumn(name = "LOAD_PROCESS_ID")
	private LoadProcess loadProcess;
	private LocalDateTime metricTime;
	private BigDecimal metricvalue;

	public MetricDevice() {
		super();

	}

	public MetricDevice(Metric metric, Device device, 
			LocalDateTime metricTime, BigDecimal metricvalue,
			LoadProcess loadProcess
			) {
		super();
		this.metric = metric;
		this.device = device;
		this.metricTime = metricTime;
		this.metricvalue = metricvalue;
		this.loadProcess= loadProcess;
	}

	public Metric getMetric() {
		return metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public LocalDateTime getMetricTime() {
		return metricTime;
	}

	public void setMetricTime(LocalDateTime metricTime) {
		this.metricTime = metricTime;
	}

	public BigDecimal getMetricvalue() {
		return metricvalue;
	}

	public void setMetricvalue(BigDecimal metricvalue) {
		this.metricvalue = metricvalue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

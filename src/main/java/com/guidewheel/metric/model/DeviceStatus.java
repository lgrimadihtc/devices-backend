package com.guidewheel.metric.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class DeviceStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "METRIC_ID")
	private Metric metric;
	@ManyToOne
	@JoinColumn(name = "DEVICE_ID")
	private Device device;
	
	private String status;
	
	private Double minVal;
	
	private Double maxVal;
	
	private Boolean noMetricStatus;
	
	

	public DeviceStatus(Metric metric, Device device, String status, Double minVal, Double maxVal,
			Boolean noMetricStatus) {
		super();
		this.metric = metric;
		this.device = device;
		this.status = status;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.noMetricStatus = noMetricStatus;
	}

	

	public DeviceStatus() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getMinVal() {
		return minVal;
	}

	public void setMinVal(Double minVal) {
		this.minVal = minVal;
	}

	public Double getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(Double maxVal) {
		this.maxVal = maxVal;
	}

	public Boolean getNoMetricStatus() {
		return noMetricStatus;
	}

	public void setNoMetricStatus(Boolean noMetricStatus) {
		this.noMetricStatus = noMetricStatus;
	}
	
	
	

	
	
}

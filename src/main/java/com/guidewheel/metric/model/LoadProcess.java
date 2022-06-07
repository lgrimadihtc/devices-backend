package com.guidewheel.metric.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class LoadProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime initDate;
	private LocalDateTime endDate;

	@ManyToOne
	@JoinColumn(name = "DEVICE_ID")
	private Device device;

	private Long metricQuantity;
	private Long totalMetric;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInitDate() {
		return initDate;
	}

	public void setInitDate(LocalDateTime initDate) {
		this.initDate = initDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Long getMetricQuantity() {
		return metricQuantity;
	}

	public void setMetricQuantity(Long metricQuantity) {
		this.metricQuantity = metricQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoadProcess(Device device) {
		super();
		this.device = device;
		this.initDate = LocalDateTime.now();
		this.status = "Processing";
		this.metricQuantity = 0L;
	}

	@Transient
	public String getDeviceName() {

		return device.getDeviceId();
	}

	public LoadProcess() {

	}

	public Long getTotalMetric() {
		return totalMetric;
	}

	public void setTotalMetric(Long totalMetric) {
		this.totalMetric = totalMetric;
	}

}

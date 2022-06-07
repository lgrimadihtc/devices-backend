package com.guidewheel.metric.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
public class DailyStatusSumary {
	
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
	@JoinColumn(name = "DEVICE_STATUS_ID")
	private DeviceStatus deviceStatus;
	
    private Long quantityMetric;
    
    private Long totalTime;	
	
	private LocalDate date;

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

	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Long getQuantityMetric() {
		return quantityMetric;
	}

	public void setQuantityMetric(Long quantityMetric) {
		this.quantityMetric = quantityMetric;
	}

	public Long getTotalTime() {
		return this.totalTime;
	}
	@Transient
	public String getStatusName() {
		return this.deviceStatus.getStatus();
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public DailyStatusSumary(Metric metric, Device device, DeviceStatus deviceStatus, Long quantityMetric,
			Long totalTime, LocalDate date) {
		super();
		this.metric = metric;
		this.device = device;
		this.deviceStatus = deviceStatus;
		this.quantityMetric = quantityMetric;
		this.totalTime = totalTime;
		this.date = date;
	}
	


	public DailyStatusSumary() {
		super();
		
	}
	


	
	
}

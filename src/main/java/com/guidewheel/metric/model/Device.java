package com.guidewheel.metric.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.guidewheel.metric.config.Constants;

@Entity
public class Device {
	@Id
	private String deviceId;

	private String description;

	private String image;

	private Integer metricEvery;//30

	private Integer expectedMetricByDay;
	
	private String energyMetric;
	
	public Device() {
		super();

	}

	public Device(String deviceId, String description, String image,Integer metricEvery,String energyMetric) {
		super();
		this.deviceId = deviceId;
		this.description = description;
		this.image = image;
		this.metricEvery=metricEvery;
		this.expectedMetricByDay=Constants.SECOND_BY_DAY/metricEvery;
		this.energyMetric=energyMetric;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getMetricEvery() {
		return metricEvery;
	}

	public void setMetricEvery(Integer metricEvery) {
		this.metricEvery = metricEvery;
	}

	public Integer getExpectedMetricByDay() {
		return expectedMetricByDay;
	}

	public void setExpectedMetricByDay(Integer expectedMetricByDay) {
		this.expectedMetricByDay = expectedMetricByDay;
	}

	public String getEnergyMetric() {
		return energyMetric;
	}

	public void setEnergyMetric(String energyMetric) {
		this.energyMetric = energyMetric;
	}
	
	

}

package com.guidewheel.metric.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.MetricDevice;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "metricdevice", path = "metricdevice")

public interface MetricDeviceRepository extends PagingAndSortingRepository<MetricDevice, Long> {

	public Page<MetricDevice> findByMetricMetricId(String Id, Pageable pageable);

	@Query(value = "SELECT min(metricTime) FROM METRIC_DEVICE m WHERE device.deviceId=:deviceId and loadProcess.id=:loadId")
	public LocalDateTime minDate(@Param("deviceId") String deviceId, @Param("loadId") Long name);

	@Query(value = "SELECT max(metricTime) FROM METRIC_DEVICE m WHERE device.deviceId=:deviceId and loadProcess.id=:loadId")
	public LocalDateTime maxDate(@Param("deviceId") String deviceId, @Param("loadId") Long name);
	
	
	@Query(value = "SELECT count(*) FROM METRIC_DEVICE m WHERE device.deviceId=:deviceId and"
			+ " loadProcess.id=:loadId and  metricTime>=:initDate and metricTime<=:endDate "
			+ "and  metricvalue>=:minvalue and metricvalue<=:maxvalue and metric.metricId=:metricId")
	public Long statusCount(@Param("deviceId") String deviceId, @Param("loadId") Long loadId,
			@Param("initDate") LocalDateTime initDate, @Param("endDate") LocalDateTime endDate,
			@Param("minvalue") BigDecimal minvalue, @Param("maxvalue") BigDecimal maxvalue,
			@Param("metricId") String metricId
			);
	
	 
	
}

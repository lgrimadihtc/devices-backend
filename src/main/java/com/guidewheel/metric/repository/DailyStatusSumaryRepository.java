package com.guidewheel.metric.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.DailyStatusSumary;
import com.guidewheel.metric.model.DeviceStatus;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "dailystatussumary", path = "dailystatussumary")
public interface  DailyStatusSumaryRepository  extends CrudRepository<DailyStatusSumary, Long> {
	

	
	@Query(value = "SELECT sum(quantityMetric) FROM DailyStatusSumary m WHERE deviceStatus.id=:id")
	public Long  sumByDeviceStatus(@Param("id") Long id);
}

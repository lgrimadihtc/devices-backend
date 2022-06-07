package com.guidewheel.metric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.DailyStatusSumary;
import com.guidewheel.metric.model.Metric;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "dailystatussumary", path = "dailystatussumary")
public interface  DailyStatusSumaryRepository  extends CrudRepository<DailyStatusSumary, Long> {
	

}

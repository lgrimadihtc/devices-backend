package com.guidewheel.metric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.Metric;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "metric", path = "metric")
public interface  MetricRepository  extends CrudRepository<Metric, String> {
	

}

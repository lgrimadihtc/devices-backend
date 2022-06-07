package com.guidewheel.metric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.LoadProcess;
import com.guidewheel.metric.model.Metric;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "loadprocess", path = "loadprocess")
public interface  LoadProcessRepository  extends CrudRepository<LoadProcess, Long > {
	

}

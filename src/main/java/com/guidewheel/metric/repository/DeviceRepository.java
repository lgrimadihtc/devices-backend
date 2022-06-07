package com.guidewheel.metric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.Device;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "device", path = "device")
public interface  DeviceRepository  extends CrudRepository<Device, String> {
	

}

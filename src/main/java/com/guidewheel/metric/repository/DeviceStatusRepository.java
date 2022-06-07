package com.guidewheel.metric.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.guidewheel.metric.model.Device;
import com.guidewheel.metric.model.DeviceStatus;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "devicestatus", path = "devicestatus")
public interface  DeviceStatusRepository  extends CrudRepository<DeviceStatus, Long> {
	
    List<DeviceStatus> findByDeviceDeviceIdOrderByMinValAsc(String deviceId);
}

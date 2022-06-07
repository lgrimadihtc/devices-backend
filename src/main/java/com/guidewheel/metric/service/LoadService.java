package com.guidewheel.metric.service;

import com.guidewheel.metric.model.LoadProcess;

public interface LoadService {
	public LoadProcess load(String pathFile, String idDevice) throws Exception;
}

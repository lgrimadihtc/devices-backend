package com.guidewheel.metric.load;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guidewheel.metric.model.Device;
import com.guidewheel.metric.model.Metric;
import com.guidewheel.metric.model.MetricDevice;
import com.guidewheel.metric.repository.DeviceRepository;
import com.guidewheel.metric.repository.MetricDeviceRepository;
import com.guidewheel.metric.repository.MetricRepository;

@Component
public class LoadComponent {

	public void load() throws URISyntaxException, IOException {

		
	}

}

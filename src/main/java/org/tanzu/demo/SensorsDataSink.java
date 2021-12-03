package org.tanzu.demo;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SensorsDataSink {

    private final Logger log = LoggerFactory.getLogger(SensorsDataSink.class);
    private static final UUID SENSOR_ID = UUID.randomUUID();

    private final SensorRepository sensorRepository;

    public SensorsDataSink(final SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void updateSensorData() {
        var sensorData = SensorData.generate(SENSOR_ID);
        log.info("Generated sensorData data: {}", sensorData);
        sensorRepository.save(sensorData);
    }

}

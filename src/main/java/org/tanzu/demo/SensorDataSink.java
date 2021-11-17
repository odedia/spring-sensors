package org.tanzu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tanzu.demo.model.Sensor;
import org.tanzu.demo.model.SensorRepository;

import java.util.function.Consumer;

@Component
public class SensorDataSink {

    private final Logger log = LoggerFactory.getLogger(SensorDataSink.class);

    private final SensorRepository sensorRepository;

    public SensorDataSink(final SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Bean
    public Consumer<Sensor> receiveSensorData() {
        return sensorData -> {
            log.info("Received sensor data: {}", sensorData);
            sensorRepository.save(sensorData);
        };
    }

}

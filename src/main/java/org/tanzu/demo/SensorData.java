package org.tanzu.demo;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SensorData {

    @Id
    private UUID id;
    private double temperature;
    private double pressure;

    public SensorData() {
    }

    public static SensorData generate(UUID id) {
        return new SensorData(id, generateTemperature(), generatePressure());
    }

    private static double generateTemperature() {
        return Math.random() * 100;
    }

    private static double generatePressure() {
        return Math.random() * 100;
    }

    
    public SensorData(UUID id, double temperature, double pressure) {
        this.id = id;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public UUID getId() {
        return id;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }
}

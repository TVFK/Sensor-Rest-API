package ru.taf.sensorrestapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MeasurementDTO {
    private double value;

    private boolean raining;

    @NotEmpty(message = "Sensor name mustn't be empty")
    @Size(min=3, max = 50, message = "Sensor name must be between 3 and 50 characters")
    private String sensorName;

    public MeasurementDTO(double value, boolean raining, String sensorName) {
        this.value = value;
        this.raining = raining;
        this.sensorName = sensorName;
    }

    public MeasurementDTO() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}

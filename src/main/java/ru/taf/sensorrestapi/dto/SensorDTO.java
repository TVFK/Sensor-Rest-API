package ru.taf.sensorrestapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
public class SensorDTO {
    @NotEmpty(message = "Sensor name mustn't be empty")
    @Size(min = 2, max = 100, message = "Sensor name must be between 2 and 100 characters")
    private String sensorName;

    public SensorDTO(String sensorName) {
        this.sensorName = sensorName;
    }

    public SensorDTO(){
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}

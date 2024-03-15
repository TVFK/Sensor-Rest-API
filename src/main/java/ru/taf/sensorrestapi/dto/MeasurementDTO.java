package ru.taf.sensorrestapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementDTO {
    private double value;

    private boolean raining;

    @NotEmpty(message = "Sensor name mustn't be empty")
    @Size(min=3, max = 50, message = "Sensor name must be between 3 and 50 characters")
    private String sensorName;
}

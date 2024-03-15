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
public class SensorDTO {

    @NotEmpty(message = "Sensor name mustn't be empty")
    @Size(min = 2, max = 100, message = "Sensor name must be between 2 and 100 characters")
    private String sensorName;
}

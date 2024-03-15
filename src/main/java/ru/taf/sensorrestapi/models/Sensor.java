package ru.taf.sensorrestapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Sensor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sensor_name")
    @NotEmpty(message = "Sensor name mustn't be empty")
    @Size(min = 3, max = 50, message = "Sensor name must be between 2 and 100 characters")
    private String sensorName;

    @OneToMany(mappedBy = "sensor")
    private List<Measurement> measurements;

    public Sensor(String sensorName){
        this.sensorName = sensorName;
    }
}

package ru.taf.sensorrestapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Sensor")
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

    public Sensor(){}

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }
}

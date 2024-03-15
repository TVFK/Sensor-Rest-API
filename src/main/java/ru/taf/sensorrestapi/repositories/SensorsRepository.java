package ru.taf.sensorrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.taf.sensorrestapi.models.Sensor;

import java.util.Optional;

public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findBySensorName(String sensorName);
}

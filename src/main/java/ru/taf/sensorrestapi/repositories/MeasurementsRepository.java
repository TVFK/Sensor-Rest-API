package ru.taf.sensorrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.taf.sensorrestapi.models.Measurement;

public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
    @Query("SELECT count(raining) FROM Measurement WHERE raining=true")
    int countRainyDays();
}

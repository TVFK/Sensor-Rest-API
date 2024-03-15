package ru.taf.sensorrestapi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.taf.sensorrestapi.models.Measurement;
import ru.taf.sensorrestapi.repositories.MeasurementsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;

    public List<Measurement> findAll(){
        return measurementsRepository.findAll();
    }

    public Measurement findOne(int id){
        return measurementsRepository.findById(id).orElse(null);
    }

    public void save(Measurement measurement){
        measurementsRepository.save(measurement);
    }

    public void update(Measurement measurement){
        measurementsRepository.save(measurement);
    }

    public void delete(int id){
        measurementsRepository.deleteById(id);
    }

    public int countRainyDays(){
        return measurementsRepository.countRainyDays();
    }
}

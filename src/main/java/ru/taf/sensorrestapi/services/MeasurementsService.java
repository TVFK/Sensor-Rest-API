package ru.taf.sensorrestapi.services;

import org.springframework.stereotype.Service;
import ru.taf.sensorrestapi.models.Measurement;
import ru.taf.sensorrestapi.repositories.MeasurementsRepository;

import java.util.List;

@Service
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;

    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

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

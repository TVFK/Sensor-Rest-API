package ru.taf.sensorrestapi.services;


import org.springframework.stereotype.Service;
import ru.taf.sensorrestapi.models.Sensor;
import ru.taf.sensorrestapi.repositories.SensorsRepository;

import java.util.List;

@Service
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Sensor findOne(String sensorName){
        return sensorsRepository.findBySensorName(sensorName).orElse(null);
    }
    public void save(Sensor sensor){
        sensorsRepository.save(sensor);
    }

}

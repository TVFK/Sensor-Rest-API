package ru.taf.sensorrestapi.util.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.taf.sensorrestapi.dto.SensorDTO;
import ru.taf.sensorrestapi.services.SensorsService;

@Component
@AllArgsConstructor
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO)target;

        if((sensorsService.findOne(sensorDTO.getSensorName())!=null)){
            errors.rejectValue("sensorName", "", "This name is already taken");
        }
    }
}

package ru.taf.sensorrestapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.taf.sensorrestapi.dto.SensorDTO;
import ru.taf.sensorrestapi.models.Sensor;
import ru.taf.sensorrestapi.services.SensorsService;
import ru.taf.sensorrestapi.util.exception.SensorErrorResponse;
import ru.taf.sensorrestapi.util.exception.SensorNotCreatedException;
import ru.taf.sensorrestapi.util.validation.SensorValidator;

import java.util.List;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
@Tag(name = "sensor_methods")
public class SensorsController {

    private final SensorsService sensorsService;
    private final SensorValidator sensorValidator;

    @Operation(
            summary = "registers the new sensor in the database"
    )
    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult){

        sensorValidator.validate(sensorDTO, bindingResult);

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new SensorNotCreatedException(errorMsg.toString());
        }
        sensorsService.save(new Sensor(sensorDTO.getSensorName()));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorNotCreatedException e){
        SensorErrorResponse response = new SensorErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

package ru.taf.sensorrestapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.taf.sensorrestapi.dto.MeasurementDTO;
import ru.taf.sensorrestapi.models.Measurement;
import ru.taf.sensorrestapi.services.MeasurementsService;
import ru.taf.sensorrestapi.services.SensorsService;
import ru.taf.sensorrestapi.util.exception.MeasurementErrorResponse;
import ru.taf.sensorrestapi.util.exception.MeasurementNotCreatedException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
@Tag(name = "measurement_methods")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
    private final SensorsService sensorsService;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    @Operation(
            summary = "adds a new measurement from the sensor"
    )
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new MeasurementNotCreatedException(errorMsg.toString());
        }
        measurementsService.save(convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    @Operation(
            summary = "returns a list of all added measurements in the database"
    )
    public List<MeasurementDTO> measurements(){
        return measurementsService.findAll().stream().map(this::convertToMeasurementDTO).toList();
    }

    @Operation(
            summary = "returns the number of all rainy days"
    )
    @GetMapping("/rainyDays")
    public int countRainyDays(){
        return measurementsService.countRainyDays();
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementNotCreatedException e){
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {

        Measurement measurement = modelMapper.map(measurementDTO, Measurement.class);
        measurement.setSensor(sensorsService.findOne(measurementDTO.getSensorName()));

        return measurement;
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement){
        MeasurementDTO measurementDTO = modelMapper.map(measurement, MeasurementDTO.class);
        measurementDTO.setSensorName(measurement.getSensor().getSensorName());

        return measurementDTO;
    }
}

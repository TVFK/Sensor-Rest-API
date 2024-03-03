package ru.taf.sensorrestapi.util.exception;

public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String msg){
        super(msg);
    }
}

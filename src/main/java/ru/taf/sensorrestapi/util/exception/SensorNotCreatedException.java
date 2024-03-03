package ru.taf.sensorrestapi.util.exception;

public class SensorNotCreatedException extends RuntimeException{
    public SensorNotCreatedException(String msg){
        super(msg);
    }
}

package com.pict.emergency.exception;

public class NoHospitalAvailableException extends RuntimeException {
    public NoHospitalAvailableException(String msg) {
        super(msg);
    }
}
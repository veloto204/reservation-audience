package com.jazzteam.borisov.exception;

public class NonAffiliationException extends RuntimeException {
    @Override
    public String getMessage() {
        return "This audience cannot belong to this department";
    }
}

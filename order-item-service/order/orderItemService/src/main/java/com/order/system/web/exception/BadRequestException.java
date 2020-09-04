package com.order.system.web.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Bad request");
    }
}
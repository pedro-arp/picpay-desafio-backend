package com.picpay.picpay_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidEmailException extends ResponseStatusException {

    public InvalidEmailException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}

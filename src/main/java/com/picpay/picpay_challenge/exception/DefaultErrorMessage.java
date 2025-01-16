package com.picpay.picpay_challenge.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DefaultErrorMessage(int status, String message) {
}

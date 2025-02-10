package com.picpay.picpay_challenge.util;

public class Constants {
    public static final String CPF_VALIDATION = "(\\d{3}[.]?\\d{3}[.]?\\d{3}-\\d{2})|(\\d{11})";
    public static final String CNPJ_VALIDATION = "(\\d{2}[.]?\\d{3}[.]?\\d{3}[/]?\\d{4}[-]?\\d{2})";
    public static final String PAYER_NOT_FOUND = "Payer not found";
    public static final String PAYEE_NOT_FOUND = "Payee not found";
    public static final String INSUFFICIENT_BALANCE = "Insufficient balance to carry out the operation";

    private Constants() {
    }
}
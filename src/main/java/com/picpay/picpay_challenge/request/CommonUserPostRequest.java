package com.picpay.picpay_challenge.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

@Setter
@Getter
@ToString
public class CommonUserPostRequest {

    @NotBlank(message = "The field 'fullName' is required")
    private String fullName;
    @NotBlank(message = "The field 'cpf' is required")
    @CPF
    private String cpf;
    @NotBlank(message = "The field 'email' is required")
    @Email(message = "The e-mail is not valid")
    private String email;
    @NotBlank(message = "The field 'password' is required")
    private String password;

    private Double accountBalance;

}



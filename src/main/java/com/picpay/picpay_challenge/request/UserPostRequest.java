package com.picpay.picpay_challenge.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserPostRequest {

    @NotBlank(message = "The field 'fullName' is required")
    private String fullName;
    @NotBlank(message = "The field 'cpfCnpj' is required")
    private String cpfCnpj;
    @NotBlank(message = "The field 'email' is required")
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,10}$", message = "The e-mail is not valid")
    private String email;
    @NotBlank(message = "The field 'password' is required")
    private String password;
}



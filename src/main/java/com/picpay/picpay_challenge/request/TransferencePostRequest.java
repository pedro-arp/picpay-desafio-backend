package com.picpay.picpay_challenge.request;

import com.picpay.picpay_challenge.domain.User;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferencePostRequest {

    private Double value;
    private User payer;
    private User payee;

}
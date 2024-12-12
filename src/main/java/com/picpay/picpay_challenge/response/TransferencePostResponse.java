package com.picpay.picpay_challenge.response;

import com.picpay.picpay_challenge.domain.User;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferencePostResponse {

    private Double value;
    private User payer;
    private User payee;

}
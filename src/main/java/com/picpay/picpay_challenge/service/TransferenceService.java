package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.CommonUser;
import com.picpay.picpay_challenge.domain.Transference;
import com.picpay.picpay_challenge.repository.CommonUserRepository;
import com.picpay.picpay_challenge.repository.TransferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenceService {

    private final TransferenceRepository transferenceRepository;

    private final CommonUserRepository commonUserRepository;

    public Transference transference(Transference transference) {

        var value = transference.getValue();

        var cpfPayer = transference.getPayer().getCpf();
        var cpfPayee = transference.getPayee().getCpf();

        CommonUser payer = commonUserRepository.findByCpf(cpfPayer);

        CommonUser payee = commonUserRepository.findByCpf(cpfPayee);

        payer.setAccountBalance(payer.getAccountBalance() - value);

        payee.setAccountBalance(payee.getAccountBalance() + value);

        commonUserRepository.save(payer);

        commonUserRepository.save(payee);

        return transferenceRepository.save(transference);
    }
}

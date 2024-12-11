package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.repository.TransferenceRepository;
import com.picpay.picpay_challenge.repository.UserRepository;
import com.picpay.picpay_challenge.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenceService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransferenceRepository transferenceRepository;


}

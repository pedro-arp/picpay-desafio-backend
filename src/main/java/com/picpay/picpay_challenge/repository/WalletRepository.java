package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUserId(Long userId);
}


package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.Transference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenceRepository extends JpaRepository<Transference, Long> {
}
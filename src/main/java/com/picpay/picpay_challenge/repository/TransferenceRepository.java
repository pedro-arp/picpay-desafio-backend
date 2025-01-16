package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.UserTransference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenceRepository extends JpaRepository<UserTransference, Long> {
}
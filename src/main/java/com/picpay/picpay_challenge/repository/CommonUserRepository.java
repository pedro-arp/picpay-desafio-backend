package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.CommonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonUserRepository extends JpaRepository<CommonUser, Long> {
    CommonUser findByCpf(String cpf);
}
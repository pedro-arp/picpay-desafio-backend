package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpfCnpj(String cpfCnpj);
}
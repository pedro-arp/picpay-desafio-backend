package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {
    Optional<Retailer> findByCnpj(String cnpj);
}
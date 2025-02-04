package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.Retailer;
import com.picpay.picpay_challenge.mapper.RetailerMapper;
import com.picpay.picpay_challenge.repository.RetailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RetailerService {

    private final RetailerRepository repository;
    private final RetailerMapper mapper;

    public List<Retailer> findAll(String firstName) {
        return repository.findAll();
    }

    public Retailer save(Retailer retailer) {
        return repository.save(retailer);
    }
}

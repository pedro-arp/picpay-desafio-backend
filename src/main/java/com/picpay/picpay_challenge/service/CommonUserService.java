package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.CommonUser;
import com.picpay.picpay_challenge.repository.CommonUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommonUserService {

    private final CommonUserRepository repository;

    public List<CommonUser> findAll() {
        return repository.findAll();
    }

    public CommonUser save(CommonUser commonUser) {
        return repository.save(commonUser);
    }

    public Optional<CommonUser> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}

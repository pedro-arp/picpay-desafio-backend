package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.User;
import com.picpay.picpay_challenge.mapper.UserMapper;
import com.picpay.picpay_challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<User> findAll(String firstName) {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }
}

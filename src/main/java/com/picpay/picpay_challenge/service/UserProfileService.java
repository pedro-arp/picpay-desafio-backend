package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.User;
import com.picpay.picpay_challenge.domain.UserProfile;
import com.picpay.picpay_challenge.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    public List<UserProfile> findAll() {
        return repository.findAll();
    }

    public List<User> findAllUsersByProfileId(Long id) {
        return repository.findAllUsersByProfileId(id);
    }

}
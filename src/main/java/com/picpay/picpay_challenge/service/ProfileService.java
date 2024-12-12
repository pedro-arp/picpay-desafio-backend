package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.Profile;
import com.picpay.picpay_challenge.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository repository;

    public List<Profile> findAll() {
        return repository.findAll();
    }

    public Profile save(Profile profile) {
        return repository.save(profile);
    }

}
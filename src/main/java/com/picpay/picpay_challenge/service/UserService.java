package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.User;
import com.picpay.picpay_challenge.exception.InvalidEmailException;
import com.picpay.picpay_challenge.exception.NotFoundException;
import com.picpay.picpay_challenge.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Transactional
    public User save(User user) {
        assertEmailIsUnique(user.getEmail(), user.getId());
        return repository.save(user);

    }

    private void assertEmailIsUnique(String email, Long userId) {
        repository.findByEmail(email)
                .ifPresent(userFound -> {
                    if (!userFound.getId().equals(userId)) {
                        throw new InvalidEmailException("email '%s' is already in use".formatted(email));
                    }
                });
    }

}

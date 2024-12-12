package com.picpay.picpay_challenge.repository;

import com.picpay.picpay_challenge.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}

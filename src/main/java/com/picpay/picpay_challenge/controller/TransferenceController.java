package com.picpay.picpay_challenge.controller;

import com.picpay.picpay_challenge.mapper.TransferenceMapper;
import com.picpay.picpay_challenge.response.TransferencePostResponse;
import com.picpay.picpay_challenge.service.TransferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/user-profiles")
@Slf4j
@RequiredArgsConstructor
public class TransferenceController {

    private final TransferenceService service;
    private final TransferenceMapper mapper;

    @GetMapping
    public ResponseEntity<List<TransferencePostResponse>> findAll() {
        log.debug("Request received to list all user profiles");


        return null;
    }

}

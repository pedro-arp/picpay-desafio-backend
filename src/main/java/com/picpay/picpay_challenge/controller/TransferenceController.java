package com.picpay.picpay_challenge.controller;

import com.picpay.picpay_challenge.mapper.TransferenceMapper;
import com.picpay.picpay_challenge.request.TransferenceUserPostRequest;
import com.picpay.picpay_challenge.response.TransferenceUserToUserPostResponse;
import com.picpay.picpay_challenge.service.TransferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transference")
@Slf4j
@RequiredArgsConstructor
public class TransferenceController {

    private final TransferenceService service;
    private final TransferenceMapper mapper;

    @PostMapping
    public ResponseEntity<TransferenceUserToUserPostResponse> save(
            @RequestBody @Valid TransferenceUserPostRequest request) {
        log.debug("Request to save transference: {}", request);
        var transference = mapper.toTransference(request);
        var transference1 = service.transference(transference);
        var transferencePostResponse = mapper.toTransferencePostResponse(transference1);
        return ResponseEntity.status(HttpStatus.CREATED).body(transferencePostResponse);

    }

}

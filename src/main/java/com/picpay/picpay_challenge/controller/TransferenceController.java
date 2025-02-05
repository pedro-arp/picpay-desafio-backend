package com.picpay.picpay_challenge.controller;

import com.picpay.picpay_challenge.request.TransferencePostRequest;
import com.picpay.picpay_challenge.service.TransferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody TransferencePostRequest request) {
        service.transference(request);
        return ResponseEntity.ok("Transfer successful");
    }

}

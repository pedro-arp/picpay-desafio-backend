package com.picpay.picpay_challenge.controller;

import com.picpay.picpay_challenge.mapper.RetailerMapper;
import com.picpay.picpay_challenge.request.RetailerPostRequest;
import com.picpay.picpay_challenge.response.RetailerGetResponse;
import com.picpay.picpay_challenge.response.RetailerPostResponse;
import com.picpay.picpay_challenge.service.RetailerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/retailers")
@Slf4j
@RequiredArgsConstructor
public class RetailerController {

    private final RetailerService service;
    private final RetailerMapper mapper;

    @GetMapping
    public ResponseEntity<List<RetailerGetResponse>> findAll(@RequestParam(required = false) String firstName) {
        log.debug("Request received to list all retailers, param first name '{}'", firstName);

        var retailers = service.findAll(firstName);

        var retailerGetResponses = mapper.toRetailerGetResponseList(retailers);

        return ResponseEntity.ok(retailerGetResponses);
    }

    @PostMapping
    public ResponseEntity<RetailerPostResponse> save(@RequestBody @Valid RetailerPostRequest request) {
        log.debug("Request to save retailer : {}", request);

        var retailer = mapper.toRetailer(request);

        var retailerSaved = service.save(retailer);

        var retailerPostResponse = mapper.toRetailerPostResponse(retailerSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(retailerPostResponse);
    }


}

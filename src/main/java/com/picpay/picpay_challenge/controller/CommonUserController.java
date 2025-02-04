package com.picpay.picpay_challenge.controller;

import com.picpay.picpay_challenge.mapper.CommonUserMapper;
import com.picpay.picpay_challenge.request.CommonUserPostRequest;
import com.picpay.picpay_challenge.response.CommonUserGetResponse;
import com.picpay.picpay_challenge.response.CommonUserPostResponse;
import com.picpay.picpay_challenge.service.CommonUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@Slf4j
@RequiredArgsConstructor
public class CommonUserController {

    private final CommonUserService service;
    private final CommonUserMapper mapper;

    @GetMapping
    public ResponseEntity<List<CommonUserGetResponse>> findAll() {

        var users = service.findAll();

        var userGetResponses = mapper.toUserGetResponseList(users);

        return ResponseEntity.ok(userGetResponses);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CommonUserGetResponse> findByCpf(@PathVariable(required = false) String cpf) {
        log.debug("Request received to list all users, param cpf '{}'", cpf);

        var user = service.findByCpf(cpf);

        var userGetResponses = mapper.toCommonUserGetResponse(user);

        return ResponseEntity.ok(userGetResponses);
    }

    @PostMapping
    public ResponseEntity<CommonUserPostResponse> save(@RequestBody @Valid CommonUserPostRequest request) {
        log.debug("Request to save user : {}", request);

        var user = mapper.toUser(request);

        var userSaved = service.save(user);

        var userPostResponse = mapper.toUserPostResponse(userSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(userPostResponse);
    }


}

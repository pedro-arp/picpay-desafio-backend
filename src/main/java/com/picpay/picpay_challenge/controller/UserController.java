package com.picpay.picpay_challenge.controller;

import com.picpay.picpay_challenge.mapper.UserMapper;
import com.picpay.picpay_challenge.request.UserPostRequest;
import com.picpay.picpay_challenge.response.UserGetResponse;
import com.picpay.picpay_challenge.response.UserPostResponse;
import com.picpay.picpay_challenge.service.UserService;
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
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> findAll(@RequestParam(required = false) String fullName) {
        log.debug("Request received to list all users, param first name '{}'", fullName);

        var users = service.findAll(fullName);

        var userGetResponses = mapper.toUserGetResponseList(users);

        return ResponseEntity.ok(userGetResponses);
    }

    @PostMapping
    public ResponseEntity<UserPostResponse> save(@RequestBody @Valid UserPostRequest request) {
        log.debug("Request to save user : {}", request);

        var user = mapper.toUser(request);

        var userSaved = service.save(user);

        var userPostResponse = mapper.toUserPostResponse(userSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(userPostResponse);
    }


}

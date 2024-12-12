package com.picpay.picpay_challenge.mapper;

import com.picpay.picpay_challenge.domain.User;
import com.picpay.picpay_challenge.request.UserPostRequest;
import com.picpay.picpay_challenge.response.UserGetResponse;
import com.picpay.picpay_challenge.response.UserPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toUser(UserPostRequest postRequest);

    UserPostResponse toUserPostResponse(User user);

    UserGetResponse toUserGetResponse(User user);

    List<UserGetResponse> toUserGetResponseList(List<User> users);
}

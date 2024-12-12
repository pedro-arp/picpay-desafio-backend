package com.picpay.picpay_challenge.mapper;

import com.picpay.picpay_challenge.domain.User;
import com.picpay.picpay_challenge.domain.UserProfile;
import com.picpay.picpay_challenge.response.UserProfileGetResponse;
import com.picpay.picpay_challenge.response.UserProfileUserGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserProfileMapper {

    List<UserProfileGetResponse> toUserProfileGetResponse(List<UserProfile> userProfiles);

    List<UserProfileUserGetResponse> toUserProfileUserGetResponseList(List<User> users);

}
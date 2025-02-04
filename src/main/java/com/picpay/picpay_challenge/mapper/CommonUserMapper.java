package com.picpay.picpay_challenge.mapper;

import com.picpay.picpay_challenge.domain.CommonUser;
import com.picpay.picpay_challenge.request.CommonUserPostRequest;
import com.picpay.picpay_challenge.response.CommonUserGetResponse;
import com.picpay.picpay_challenge.response.CommonUserPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommonUserMapper {

    CommonUser toUser(CommonUserPostRequest postRequest);

    CommonUserPostResponse toUserPostResponse(CommonUser commonUser);

    List<CommonUserGetResponse> toUserGetResponseList(List<CommonUser> commonUsers);

    CommonUserGetResponse toCommonUserGetResponse(CommonUser commonUser);
}

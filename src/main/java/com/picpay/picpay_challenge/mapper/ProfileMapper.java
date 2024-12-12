package com.picpay.picpay_challenge.mapper;

import com.picpay.picpay_challenge.domain.Profile;
import com.picpay.picpay_challenge.request.ProfilePostRequest;
import com.picpay.picpay_challenge.response.ProfileGetResponse;
import com.picpay.picpay_challenge.response.ProfilePostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile toProfile(ProfilePostRequest postRequest);

    ProfilePostResponse toProfilePostResponse(Profile profile);

    ProfileGetResponse toProfileGetResponse(Profile profile);

    List<ProfileGetResponse> toProfileGetResponseList(List<Profile> profiles);

}

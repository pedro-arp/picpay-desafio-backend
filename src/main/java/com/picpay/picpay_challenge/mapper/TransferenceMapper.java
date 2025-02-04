package com.picpay.picpay_challenge.mapper;

import com.picpay.picpay_challenge.domain.Transference;
import com.picpay.picpay_challenge.request.TransferenceUserPostRequest;
import com.picpay.picpay_challenge.response.TransferenceUserToUserPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransferenceMapper {

    Transference toTransference(TransferenceUserPostRequest transferenceUserPostRequest);

    TransferenceUserToUserPostResponse toTransferencePostResponse(Transference transference);

}

package com.picpay.picpay_challenge.mapper;

import com.picpay.picpay_challenge.domain.Retailer;
import com.picpay.picpay_challenge.request.RetailerPostRequest;
import com.picpay.picpay_challenge.response.RetailerGetResponse;
import com.picpay.picpay_challenge.response.RetailerPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RetailerMapper {

    Retailer toRetailer(RetailerPostRequest postRequest);

    RetailerPostResponse toRetailerPostResponse(Retailer retailer);

    RetailerGetResponse toRetailerGetResponse(Retailer retailer);

    List<RetailerGetResponse> toRetailerGetResponseList(List<Retailer> retailers);


}

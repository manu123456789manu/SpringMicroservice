package com.gl.orderManagementApp.service;

import com.gl.orderManagementApp.dto.SellerDto;

import java.util.List;

/**
 * @author - manu
 */
public interface UserRegistrationService {
    String registerSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}

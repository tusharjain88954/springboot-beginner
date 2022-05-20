package com.groww.addressesservice.service;

import com.groww.addressesservice.shared.AddressDTO;

import java.util.List;


public interface AddressService {
	AddressDTO getAddresses(int userId);
	AddressDTO getAddress(int addressId);

}

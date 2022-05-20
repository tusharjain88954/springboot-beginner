package com.groww.addressesservice.service.impl;

import com.groww.addressesservice.io.entity.AddressEntity;
import com.groww.addressesservice.io.repository.AddressRepository;
import com.groww.addressesservice.service.AddressService;
import com.groww.addressesservice.shared.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {


	@Autowired
    AddressRepository addressRepository;
	
	@Override
	public AddressDTO getAddresses(int userId) {
        AddressDTO returnValue = null;
        ModelMapper modelMapper = new ModelMapper();

        AddressEntity address = addressRepository.findByUserId(userId);


        returnValue = modelMapper.map(address, AddressDTO.class);

        return returnValue;
	}

	@Override
	public AddressDTO getAddress(int addressId) {
		AddressDTO returnValue = null;

        AddressEntity addressEntity = addressRepository.findById(addressId);
        
        if(addressEntity!=null)
        {
            returnValue = new ModelMapper().map(addressEntity, AddressDTO.class);
        }
 
        return returnValue;
	}

}
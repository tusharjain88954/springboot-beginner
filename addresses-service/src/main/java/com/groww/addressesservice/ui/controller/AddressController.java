package com.groww.addressesservice.ui.controller;

import com.groww.addressesservice.io.entity.AddressEntity;
import com.groww.addressesservice.io.repository.AddressRepository;
import com.groww.addressesservice.service.AddressService;
import com.groww.addressesservice.shared.AddressDTO;
import com.groww.addressesservice.ui.models.AddressesRequest;
import com.groww.addressesservice.ui.models.AddressRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    AddressService addressesService;

    @Autowired
    AddressRepository addressRepository;


    @GetMapping(path = "/users/{userId}/addresses", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public AddressRest getUserAddresses(@PathVariable int userId) {
        AddressRest returnValue = null;

        AddressDTO addressesDTO = addressesService.getAddresses(userId);

        returnValue = new ModelMapper().map(addressesDTO, AddressRest.class);
        return returnValue;
    }

    @GetMapping(path = "/addresses/{addressId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public AddressRest getUserAddress(@PathVariable int addressId) {
        AddressDTO addressDTO = addressesService.getAddress(addressId);
        ModelMapper modelMapper = new ModelMapper();
        AddressRest returnValue = modelMapper.map(addressDTO, AddressRest.class);
        return returnValue;
    }


    @PostMapping(path="/addresses", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void createAddresses(@RequestBody AddressesRequest addressDetails){

            ModelMapper modelMapper = new ModelMapper();
            AddressEntity addressesEntity = modelMapper.map(addressDetails ,AddressEntity.class);
            addressRepository.save(addressesEntity);
    }



}

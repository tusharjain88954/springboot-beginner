package com.groww.addressesservice.io.repository;

import com.groww.addressesservice.io.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

	AddressEntity findById(long Id);
	AddressEntity findByUserId(int userId);
}

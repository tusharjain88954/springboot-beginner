package com.groww.addressesservice.ui.models;

import org.springframework.hateoas.RepresentationModel;


public class AddressRest extends RepresentationModel<AddressRest> {
	private String city;
	private String country;

	public AddressRest() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

package com.icesi.samaca.backend.services;

import com.icesi.samaca.backend.model.person.Address;


public interface AddressService {
	
	
	
	public Address saveAddress(Address addr) ;
	public Address deleteAddress(Integer addressid) ;
	public Address editAddres(Address addr);
	
	
	

}

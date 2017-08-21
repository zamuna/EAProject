package org.mum.edu.ea.serviceimpl;


import org.mum.edu.ea.domain.Address;
import org.mum.edu.ea.repository.AddressRepository;
import org.mum.edu.ea.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService{
    
	
	@Autowired
	private AddressRepository addressrepository;
	@Override
	public Address findByZipcode(String zipcode) {
	    
		Address address = addressrepository.findByZipcode(zipcode);
		
		return address;
	}
      
}

package org.mum.edu.ea.service;

import org.mum.edu.ea.domain.Address;

public interface AddressService {
     
	Address findByZipcode(String zipcode);
}

package org.mum.edu.ea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.mum.edu.ea.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
	
	/**
	 * 
	 * @param zipcode
	 * @return <strong>Address</strong>
	 */
	Address findByZipcode(String zipcode);
        
}

package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.domain.WebUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
	
	
	WebUser findWebUserByEmail(String email);
	
	WebUser findByUsername(String email);

}

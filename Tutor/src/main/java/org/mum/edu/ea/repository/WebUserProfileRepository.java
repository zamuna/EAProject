package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.WebUserProfile;
import org.mum.edu.ea.domain.WebUserProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WebUserProfileRepository extends JpaRepository<WebUserProfile, Long> {
     
	 WebUserProfile findByRole(String role);
}

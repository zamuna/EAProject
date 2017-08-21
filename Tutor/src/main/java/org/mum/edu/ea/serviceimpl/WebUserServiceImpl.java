
package org.mum.edu.ea.serviceimpl;

import java.util.List;
import java.util.Set;

import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.domain.WebUserProfile;
import org.mum.edu.ea.domain.WebUserProfileType;
import org.mum.edu.ea.repository.WebUserProfileRepository;
import org.mum.edu.ea.repository.WebUserRepository;
import org.mum.edu.ea.service.WebUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WebUserServiceImpl implements WebUserService {
	// We must implement AOP for logging later
	private static final Logger LOG = LoggerFactory.getLogger(WebUser.class);
	@Autowired
	private WebUserRepository userRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private WebUserProfileRepository wurepository;

	/**
	 * @param email
	 */
	@Override
	public WebUser findByEmail(String email) {
		WebUser user = userRepository.findWebUserByEmail(email);
		return user;
	}


    /**
     * @param id
     */

    @Override
    @Transactional
    public WebUser findById(Long id) {
        WebUser user = userRepository.findOne(id);
        return user;
    }
    
    

	@Transactional
	@Override
	public WebUser createUser(WebUser user, Set<WebUserProfile> userRoles) throws Exception {
		//
		WebUser localUser = userRepository.findByUsername(user.getUsername());
		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getEmail());
		} else {

			user.getWebUserProfileCollection().addAll(userRoles);

            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    @Transactional
    public void save(WebUser user) {
		System.out.println("------webuser---begin");
		WebUserProfile wu = wurepository.findByRole(WebUserProfileType.USER.name());
		if(wu == null){
			wu = new WebUserProfile();
			wu.setRole(WebUserProfileType.USER.name());
		}
		System.out.println("------webuser---begin---"+wu.getRole());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setConfirmedpassword("");
		user.addProfile(wu);
		userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long Id) {

        userRepository.delete(Id);
    }

    @Override
    @Transactional
    public List<WebUser> findAll() {
        return userRepository.findAll();
    }

	@Override
	 @Transactional
	public WebUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}

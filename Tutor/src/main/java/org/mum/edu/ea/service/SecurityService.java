package org.mum.edu.ea.service;

public interface SecurityService {
	
	 String findLoggedInUsername();

	 void autologin(String username, String password);

}

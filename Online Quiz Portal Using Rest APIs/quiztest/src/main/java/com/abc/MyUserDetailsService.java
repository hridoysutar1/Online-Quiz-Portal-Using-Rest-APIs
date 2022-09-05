package com.abc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository uRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=uRepo.findByUsername(username);
		if(user==null) {
			throw new  UsernameNotFoundException("not found");
		}
		
		return new MyUserDetailsImp(user);
	}

}

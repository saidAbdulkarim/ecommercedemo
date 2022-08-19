package ecommerce.serviceImplementaion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ecommerce.model.CustomUserDetails;
import ecommerce.model.User;
import ecommerce.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException("user not foun"));
		return user.map(CustomUserDetails::new).get();
		
	}

}

package com.banking.user.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banking.user.entity.User;
import com.banking.user.entity.UserRole;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private com.banking.user.repository.UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmailID(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with name :" + username);
		}

		Collection<? extends GrantedAuthority> roles = getGrantedAuthorities(user.getUserRoles());
		UserDetails userDtls = new org.springframework.security.core.userdetails.User(user.getEmailID(),
				user.getPassword(), roles);
		System.out.println(userDtls);
		return userDtls;
	}

	private List<GrantedAuthority> getGrantedAuthorities(Set<UserRole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (UserRole role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		}
		return authorities;
	}

}

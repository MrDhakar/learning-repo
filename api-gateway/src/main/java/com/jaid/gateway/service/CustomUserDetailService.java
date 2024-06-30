package com.jaid.gateway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jaid.gateway.entitiy.Privilege;
import com.jaid.gateway.entitiy.Role;
import com.jaid.gateway.entitiy.User;
import com.jaid.gateway.repository.RoleRepository;
import com.jaid.gateway.repository.UserRepository;

@Service
public class CustomUserDetailService implements ICustomUserDetailService,UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User registerNewUserAccount(User user) throws Exception  {
	   
	    user.setFirstName(user.getFirstName());
	    user.setLastName(user.getLastName());
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setEmail(user.getEmail());
	    user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
	    return userRepository.save(user);
	}
	
	/*
	 * public UserDetailsService userDetailsService(String username) {
	 * 
	 * UserDetails user =
	 * User.withUsername("user").password("password").roles("USER").build(); return
	 * new InMemoryUserDetailsManager(user);
	 * 
	 * }
	 */
	/*
	 * @Override public UserDetails findByUsername(String username) {
	 * 
	 * return new User("JAID", "JAID", (Collection<? extends GrantedAuthority>) new
	 * ArrayList<GrantedAuthority>()); }
	 */

	@Override
	public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {

		final Set<GrantedAuthority> grantedAuths = new HashSet<>();
	    grantedAuths.add(new RoleGrantedAuthority("ROLE_USER"));
		//return new CustomUserDetails(username, "JAID", grantedAuths);
		
		User user = userRepository.findByName(username);
	        if (user == null) {
	            return new org.springframework.security.core.userdetails.User(
	              " ", " ", true, true, true, true, 
	              getAuthorities(Arrays.asList(
	                roleRepository.findByName("ROLE_USER"))));
	        }

	        return new org.springframework.security.core.userdetails.User(
	          user.getEmail(), user.getPassword(), user.isEnabled(), true, true, 
	          true, getAuthorities(user.getRoles()));
		
	}
	

    private Collection<? extends GrantedAuthority> getAuthorities(
      Collection<Role> roles) {
 
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
 
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        
        // In spring role and privilege are same;
        
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new RoleGrantedAuthority(privilege));
        }
        return authorities;
    }
}

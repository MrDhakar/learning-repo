package com.jaid.gateway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jaid.gateway.entitiy.Privilege;
import com.jaid.gateway.entitiy.Role;
import com.jaid.gateway.entitiy.Users;
import com.jaid.gateway.repository.PrivilegeRepository;
import com.jaid.gateway.repository.RoleRepository;
import com.jaid.gateway.repository.UserRepository;

@Service
public class CustomUserDetailService implements ICustomUserDetailService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegeRepository previlegeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public Users registerNewUserAccount(Users user) throws Exception  {
	   
	    user.setName(user.getName());
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final Set<GrantedAuthority> grantedAuths = new HashSet<>();
	    grantedAuths.add(new RoleGrantedAuthority("ROLE_USER"));
		//return new CustomUserDetails(username, "JAID", grantedAuths);
		
		Users user = userRepository.findByName(username);
		List<Role> roles = Arrays.asList(roleRepository.findByName("ROLE_USER"));
		List<Privilege> privileges =  Arrays.asList(previlegeRepository.findByName("READ_PRIVILEGE"));
		
		user.setRoles(roles);
		
	        if (user == null) {
	            return new org.springframework.security.core.userdetails.User(
	              " ", " ", true, true, true, true, 
	              getAuthorities(Arrays.asList(
	                roleRepository.findByName("ROLE_USER"))));
	        }
	        return new CustomUserDetails(user.getName(), user.getPassword(),getAuthorities(user.getRoles()) );
			/*
			 * return new org.springframework.security.core.userdetails.User(
			 * user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true,
			 * getAuthorities(user.getRoles()));
			 */
		
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
            //collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private Set<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (String privilege : privileges) {
            authorities.add(new RoleGrantedAuthority(privilege));
        }
        return authorities;
    }

}

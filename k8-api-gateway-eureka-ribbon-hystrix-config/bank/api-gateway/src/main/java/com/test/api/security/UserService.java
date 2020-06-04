package com.test.api.security;

import com.test.api.dto.DBUserDetails;
import com.test.api.dto.Role;
import com.test.api.dto.User;
import com.test.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
           // throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
            user = userRepository.findByEmail(email);
            user = new User();
            user.setEmail("username");
            user.setPassword("password");
            Role r = new Role();;
            r.setRole("Admin");

            Set<Role> roles = new HashSet<>();
            roles.add(r);
            user.setRole(roles);

        }
        String [] authorities = new String[user.getRole().size()];
        int count=0;
        for (Role role : user.getRole()) {
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            authorities[count] = "ROLE_"+role.getRole();
            count++;
        }
        DBUserDetails userDetails = new DBUserDetails(user.getEmail(),user.getPassword(),user.getActive(),
                user.isLoacked(), user.isExpired(),user.isEnabled(),authorities);
        return userDetails;
    }



}

package com.nff.security.jwtutil;

import com.nff.security.entity.UserEntity;
import com.nff.security.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user= repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found "));


        return new org.springframework.security.core.userdetails
                .User(user.getUsername()
                ,user.getPassword()
                ,user.getRoles().stream().map(SimpleGrantedAuthority::new).toList());
    }
}

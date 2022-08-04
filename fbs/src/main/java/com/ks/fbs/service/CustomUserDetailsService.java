package com.ks.fbs.service;

import com.ks.fbs.model.CustomUserDetail;
import com.ks.fbs.model.User;
import com.ks.fbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByEmail(username);
        user.orElseThrow(()->new UsernameNotFoundException("Invalid Credential!!!!"));
        return user.map(CustomUserDetail::new).get();
    }
}

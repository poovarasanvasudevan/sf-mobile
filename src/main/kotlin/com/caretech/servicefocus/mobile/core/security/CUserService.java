package com.caretech.servicefocus.mobile.core.security;

import com.caretech.servicefocus.mobile.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class CUserService implements UserDetailsService {

    private final
    UserRepo userRepo;

    @Autowired
    public CUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findUserByUserNameAndIsActiveIsTrue(s);
    }
}

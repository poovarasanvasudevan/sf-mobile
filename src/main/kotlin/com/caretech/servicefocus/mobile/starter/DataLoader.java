package com.caretech.servicefocus.mobile.starter;

import com.caretech.servicefocus.mobile.model.User;
import com.caretech.servicefocus.mobile.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataLoader implements CommandLineRunner {

    final
    PasswordEncoder passwordEncoder;

    final
    UserRepo userRepo;

    @Autowired
    public DataLoader(PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }


    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserName("poosan");
        user.setPassword(passwordEncoder.encode("poosan"));
        user.setFirstName("Poovarasan");
        user.setLastName("Vasudevan");
        user.setActive(true);
        user.setEmail("poosan@poosan.com");


        Map<String,Object> attr = new HashMap<>();
        attr.put("age" , 20);
        user.setAttributes(attr);

       // userRepo.save(user);
    }
}

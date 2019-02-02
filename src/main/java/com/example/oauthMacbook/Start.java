package com.example.oauthMacbook;

import com.example.oauthMacbook.domain.User;
import com.example.oauthMacbook.repository.MeinUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Start {

    @Autowired
    private MeinUserRepository userRepository;

    @PostConstruct
    public void createUsers(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User richard = new User("richard", encoder.encode("test123"));
        User toni = new User("toni", encoder.encode("flusensieb"));

        userRepository.save(richard);
        userRepository.save(toni);
    }
}

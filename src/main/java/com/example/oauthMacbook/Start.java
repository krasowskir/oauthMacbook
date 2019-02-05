package com.example.oauthMacbook;

import com.example.oauthMacbook.domain.User;
import com.example.oauthMacbook.service.MeinUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Start {


    private static Logger LOGGER = LoggerFactory.getLogger(Start.class);

    @Autowired
    private MeinUserService meinUserService;


    @PostConstruct
    public void createUsers(){

        //PasswordEncoder encoder = new BCryptPasswordEncoder();
        User richard = new User("richard", "test123");
        User toni = new User("toni", "flusensieb");

        meinUserService.saveUser(richard);
        meinUserService.saveUser(toni);

    }
}

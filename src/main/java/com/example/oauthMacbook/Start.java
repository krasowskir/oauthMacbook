package com.example.oauthMacbook;

import com.example.oauthMacbook.domain.User;
import com.example.oauthMacbook.service.MeinUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import java.util.List;


@Component
public class Start {

    private static Logger LOGGER = LoggerFactory.getLogger(Start.class);

    @Autowired
    private MeinUserService meinUserService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    @Qualifier("springSecurityFilterChain")
    private Filter springSecurityFilterChain;

    @PostConstruct
    public void createUsers(){

//        System.out.println("===== root beans ======");
//
//        for (String elem : applicationContext.getBeanDefinitionNames()){
//            System.out.println(elem);
//        }
//
//        System.out.println("===== web beans ======");
//
//        for (String elem : webApplicationContext.getBeanDefinitionNames()){
//            System.out.println(elem);
//        }
//
        List<SecurityFilterChain> filterChain = ((FilterChainProxy)springSecurityFilterChain).getFilterChains();
        for (SecurityFilterChain elem : filterChain){
            System.out.println(elem.getFilters());
        }

        //PasswordEncoder encoder = new BCryptPasswordEncoder();
        User richard = new User("richard", "test123");
        User toni = new User("toni", "flusensieb");

        meinUserService.saveUser(richard);
        meinUserService.saveUser(toni);

    }

}

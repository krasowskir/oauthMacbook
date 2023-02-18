//package com.example.oauthMacbook;
//
//import com.example.oauthMacbook.domain.Client;
//import com.example.oauthMacbook.domain.User;
//import com.example.oauthMacbook.service.MeinClientService;
//import com.example.oauthMacbook.service.MeinUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.Filter;
//import java.util.List;
//
//
//@Component
//public class Start {
//
//    @Autowired
//    private MeinUserService meinUserService;
//
//    @Autowired
//    private MeinClientService meinClientService;
//
//
//    @Autowired
//    @Qualifier("springSecurityFilterChain")
//    private Filter springSecurityFilterChain;
//
//    @PostConstruct
//    public void createUsers(){
//
//        List<SecurityFilterChain> filterChain = ((FilterChainProxy)springSecurityFilterChain).getFilterChains();
//        for (SecurityFilterChain elem : filterChain){
//            System.out.println(elem.getFilters());
//        }
//
//        //PasswordEncoder encoder = new BCryptPasswordEncoder();
//        User richard = new User("richard", "test123");
//        User toni = new User("toni", "flusensieb");
//
//        Client richClient = new Client("richard", "meinPasswort123");
//
//        meinUserService.saveUser(richard);
//        meinUserService.saveUser(toni);
//
//        meinClientService.saveClient(richClient);
//
//    }
//
//}

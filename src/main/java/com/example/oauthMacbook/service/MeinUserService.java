package com.example.oauthMacbook.service;

import com.example.oauthMacbook.domain.User;
import com.example.oauthMacbook.repository.MeinUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeinUserService implements UserDetailsService{

    private static Logger LOGGER = LoggerFactory.getLogger(MeinUserService.class);

    @Autowired
    private MeinUserRepository userRepository;


    @Transactional
    public User saveUser(User toSave){
        try {
            User toPersist = new User();
            toPersist.setUsername(toSave.getUsername());
            toPersist.setPassword(toSave.getPassword());
            return userRepository.save(toPersist);
        } catch (Exception e){
            LOGGER.error(String.format("Speichern des Users %s hat nicht geklappt", toSave), e );
        }
        return new User();
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User tmpUser = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (tmpUser.getUsername().equals("richard")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if (tmpUser.getUsername().equals("toni")){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        System.out.println("===" + tmpUser + ": authorities: " + authorities + "===");
        return new org.springframework.security.core.userdetails.User(tmpUser.getUsername(), tmpUser.getPassword(), authorities);
    }


}

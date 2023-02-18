package com.example.oauthMacbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@RestController
public class MyPageController {

    private ObjectMapper objectMapper;

    @Autowired
    private JdbcClientDetailsService clientDetailsService;

    @Autowired
    public MyPageController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/meineSeite")
    public String successfullLoginPage(){
        return "meineSeite";
    }

    @PostMapping("/registration/client/{clientSecret}")
    @Transactional
    public ClientDetails registerClient(@RequestBody String clientInformation) throws IOException {
        ClientInformation clientInfoDTO = objectMapper.readValue(clientInformation, ClientInformation.class);

        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(clientInfoDTO.getClientId());
        clientDetails.setClientSecret(clientInfoDTO.getClientSecret());
        clientDetails.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        clientDetails.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "client_credentials"));
        clientDetails.setScope(Arrays.asList("read", "write"));

        clientDetailsService.addClientDetails(clientDetails);
        return clientDetailsService.loadClientByClientId(clientDetails.getClientId());
    }
}

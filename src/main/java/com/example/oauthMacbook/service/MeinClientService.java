package com.example.oauthMacbook.service;

import com.example.oauthMacbook.domain.Client;
import com.example.oauthMacbook.repository.MeinClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MeinClientService implements ClientDetailsService{

    @Autowired
    private MeinClientsRepository meinClientsRepository;

    @Transactional
    public Client saveClient(Client client){
        return meinClientsRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client foundClient = meinClientsRepository.findByClientId(clientId);

        BaseClientDetails result = new BaseClientDetails();
        result.setClientId(foundClient.getClientId());
        result.setClientSecret(foundClient.getClientSecret());
        result.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        result.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "client_credentials"));
        result.setScope(Arrays.asList("read"));
        Set<String> redirectUris = new HashSet<String>();
        redirectUris.add("http://example.com");
        result.setRegisteredRedirectUri(redirectUris);
        return result;
    }
}

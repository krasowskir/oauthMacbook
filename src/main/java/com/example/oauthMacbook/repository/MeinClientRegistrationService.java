package com.example.oauthMacbook.repository;

import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import java.util.List;

public class MeinClientRegistrationService implements ClientRegistrationService {


    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {

    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {

    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {

    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {

    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return null;
    }
}

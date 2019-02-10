package com.example.oauthMacbook.domain;

import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Base64;
import java.util.UUID;

@Entity
public class Client {

    @Id
    private UUID id;
    private String clientId;
    private String clientSecret;

    public Client() {
        this.id = UUID.randomUUID();
    }

    public Client(String clientId, String clientSecret) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Client(String clientId){
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.clientSecret = generateClientSecret().toString();
    }

    public byte[] generateClientSecret(){
        return Base64.getEncoder().encode(RandomStringUtils.random(10, true,true).getBytes());
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }
}

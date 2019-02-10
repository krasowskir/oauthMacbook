package com.example.oauthMacbook.config;


import com.example.oauthMacbook.service.MeinClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private MeinClientService meinClientDetailsService;
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {

        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients
                .withClientDetails(meinClientDetailsService);

//                .inMemory()
//                .withClient("richard")
//                .secret("meinPasswort123")
//                .scopes("read", "write")
//                .authorities("ROLE_CLIENT")
//                .authorizedGrantTypes("authorization_code", "client_credentials")
//                .redirectUris("http://example.com");
    }
}

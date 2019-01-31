//package com.example.oauthMacbook.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//@Configuration
//public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//
//        oauthServer
//                .tokenKeyAccess("permit")
//                .checkTokenAccess("isAuthenticated");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//        clients
//                .inMemory()
//                .withClient("richard")
//                .secret("meinPasswort123")
//                .scopes("read")
//                .authorities("ROLE_CLIENT")
//                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit")
//                .autoApprove(true)
//                .and()
//                .withClient("toni")
//                .secret("flusensieb")
//                .scopes("read", "write")
//                .authorities("ROLE_CLIENT")
//                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit")
//                .autoApprove(true);
//    }
//}

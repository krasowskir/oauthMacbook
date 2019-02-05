package com.example.oauthMacbook.config;

import com.example.oauthMacbook.security.RichardsFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@EnableResourceServer
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new RichardsFilter(), LogoutFilter.class)
                .authorizeRequests()
                .regexMatchers("/oauth/token").permitAll()
                .regexMatchers("/api/.*").authenticated()
                .anyRequest().authenticated();
    }
}

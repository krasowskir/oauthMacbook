package com.example.oauthMacbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                    .withUser("richard")
                    .password(passwordEncoder.encode("meinPasswort123"))
                    .roles("USER")
                .and()
                    .withUser("toni")
                    .password(passwordEncoder.encode("flusensieb"))
                    .roles("TEST")
                .and()
                .passwordEncoder(passwordEncoder);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .regexMatchers("/.*").access("hasRole('USER')")
                .regexMatchers("/oauth/authorize").access("hasRole('USER')")
                .regexMatchers("/oauth/token").access("hasRole('USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and().httpBasic();
    }
}

package com.example.oauthMacbook.config;

import com.example.oauthMacbook.security.RichardsFilter;
import com.example.oauthMacbook.service.MeinUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Order(2)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private static Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private MeinUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userService)
            .passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .regexMatchers("/login").permitAll()
                .regexMatchers("/endpunkt/test").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successForwardUrl("/meineSeite")
                .and().logout()

                // .logoutSuccessUrl("/login") wohin man den user nach dem logout redirecten möchte

                .and()
                .rememberMe()
                 .tokenValiditySeconds(2419200)
                 .key("richardsKey")
                .and()
                .addFilterAfter(new RichardsFilter(), LogoutFilter.class)
                //auskommentieren, um das zu aktivieren. Dafür braucht man dann ein csrf token Repository
                .csrf().disable();
    }


}

package com.example.oauthMacbook.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${database.db.host}")
    private String host;

    @Value("${database.db.port}")
    private String port;

    @Value("${database.db.username}")
    private String username;

    @Value("${database.db.password}")
    private String password;

//    @Autowired
//    private MeinClientService meinClientDetailsService;

    //system property spring.security.strategy=MODE_GLOBAL

    @Bean
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("cookbook");
        dataSource.setMaximumPoolSize(20);
        dataSource.setMinimumIdle(2);
        dataSource.addDataSourceProperty("cachePrepStmts", Boolean.TRUE);
        dataSource.addDataSourceProperty("prepStmtCacheSize", 512);
        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", 1024);
        dataSource.addDataSourceProperty("useServerPrepStmts", Boolean.TRUE);

        dataSource.setDriverClassName("org.postgresql.Driver");
        String jdbcUrl = "jdbc:postgresql://" + host + ":" + port + "/users";
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setConnectionTimeout(120000L);
        dataSource.setAutoCommit(false);
        return dataSource;

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {

        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }

    public PasswordEncoder bCryptPasswordEncoder(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Bean
    @Autowired
    public JdbcClientDetailsService jdbcClientDetailsService(){
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource());
        clientDetailsService.setPasswordEncoder(bCryptPasswordEncoder());
        return clientDetailsService;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients
                .withClientDetails(jdbcClientDetailsService());

//                .inMemory()
//                .withClient("richard")
//                .secret("meinPasswort123")
//                .scopes("read", "write")
//                .authorities("ROLE_CLIENT")
//                .authorizedGrantTypes("authorization_code", "client_credentials")
//                .redirectUris("http://example.com");
    }
}

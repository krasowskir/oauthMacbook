package com.example.oauthMacbook.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;


public class RichardsFilter extends GenericFilterBean{

    private static Logger LOGGER = LoggerFactory.getLogger(RichardsFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest meinRequest = (HttpServletRequest)servletRequest;
        Enumeration<String> headers = meinRequest.getHeaderNames();
        while (headers.hasMoreElements()){
            String headerElem = headers.nextElement();
            LOGGER.info("--- header: " + headerElem);
        }

        LOGGER.info("=== Nutzer: " + meinRequest.getRemoteUser() + " principal: " + meinRequest.getUserPrincipal() + " auth: " +meinRequest.getAuthType()  + "===");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

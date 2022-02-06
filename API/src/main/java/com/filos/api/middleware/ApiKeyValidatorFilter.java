package com.filos.api.middleware;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Order(1)
//@Component
@RequiredArgsConstructor
public class ApiKeyValidatorFilter implements Filter {

    private final String headerKey = "X-API-KEY";
    private final KeyValidator keyValidator;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String key = request.getHeader(headerKey);
        log.debug("Checking the key from header.");

        if (!keyValidator.valid(key)) {
            log.debug("Key is not valid.");
            ((HttpServletResponse) servletResponse).setStatus(403);
            servletResponse.getOutputStream().write("API Key is invalid".getBytes());
            return;
        }
        log.debug("Key is valid.");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    interface KeyValidator {
        boolean valid(String key);
    }
}

package com.filos.api.middleware;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class PostRateLimitFilter implements Filter {

    private final RateLimiter rateLimiter;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteAddr = servletRequest.getRemoteAddr();

        if (!rateLimiter.canAccess(remoteAddr)) {
            ((HttpServletResponse) servletResponse).setStatus(429);
            servletResponse.getOutputStream().write("Too Many Requests".getBytes());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    public interface RateLimiter {
        boolean canAccess(String ip);
    }
}

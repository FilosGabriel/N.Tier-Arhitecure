package com.filos.api.config.web;

import com.filos.api.middleware.PostRateLimitFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class WebFiltersConfiguration {
    @Bean
    @ConditionalOnProperty(value = "web.rate-limiter.enabled", havingValue = "false")
    FilterRegistrationBean<PostRateLimitFilter> registrationPostRateLimiter(PostRateLimitFilter.RateLimiter rateLimiter) {
        FilterRegistrationBean<PostRateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new PostRateLimitFilter(rateLimiter));
        return registrationBean;
    }
}

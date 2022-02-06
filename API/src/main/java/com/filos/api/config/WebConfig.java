package com.filos.api.config;

import com.filos.api.middleware.PostRateLimitFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.util.Pair;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    private final String basePath = "com.filos.api.controllers";

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setPatternParser(new PathPatternParser());
        getVersioningPackages(basePath)
                .forEach(version -> configurer.addPathPrefix(version.getFirst(),
                        HandlerTypePredicate.forBasePackage(version.getSecond())));
    }

    @Bean
    @ConditionalOnProperty(value = "web.rate-limiter.enabled", havingValue = "false")
    FilterRegistrationBean<PostRateLimitFilter> registrationPostRateLimiter(PostRateLimitFilter.RateLimiter rateLimiter) {
        FilterRegistrationBean<PostRateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new PostRateLimitFilter(rateLimiter));
        return registrationBean;
    }

    private List<Pair<String, String>> getVersioningPackages(String basePath) {
        Package[] packages = Package.getPackages();
        String pathToSearch = basePath + ".v[0-9]+";
        List<Pair<String, String>> versions = new ArrayList<>();
        for (Package controllerPackage : packages) {
            if (controllerPackage.getName().matches(pathToSearch)) {
                String[] split = controllerPackage.getName().split("\\.");
                versions.add(Pair.of(split[split.length - 1], controllerPackage.getName()));
                log.info("Register {} {}", split[split.length - 1], controllerPackage.getName());
            }
        }
        return versions;
    }
}

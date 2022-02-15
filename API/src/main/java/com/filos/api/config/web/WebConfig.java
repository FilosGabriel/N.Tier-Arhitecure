package com.filos.api.config.web;

import lombok.extern.slf4j.Slf4j;
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


    private List<Pair<String, String>> getVersioningPackages(String basePath) {
        Package[] packages = Package.getPackages();
        String pathToSearch = basePath + ".v[0-9]+";
        List<Pair<String, String>> versions = new ArrayList<>();
        for (Package controllerPackage : packages) {
            if (controllerPackage.getName().matches(pathToSearch)) {
                String[] split = controllerPackage.getName().split("\\.");
                versions.add(Pair.of(split[split.length - 1], controllerPackage.getName()));
                log.info("Registering module {} as {}", controllerPackage.getName(), split[split.length - 1]);
            }
        }
        return versions;
    }


}

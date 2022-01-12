package com.filos.application.configuration.email;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
        ignoreResourceNotFound = true,
        value = "classpath:application-module-application.yml"
)
public class ConfigApplicationModule {
}

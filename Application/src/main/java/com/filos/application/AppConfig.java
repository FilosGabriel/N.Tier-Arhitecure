package com.filos.application;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "web.rate-limiter")
public class AppConfig {

    private boolean enabled;
    private String maxRate;
}

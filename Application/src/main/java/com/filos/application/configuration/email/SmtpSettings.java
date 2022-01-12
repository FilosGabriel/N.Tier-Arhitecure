package com.filos.application.configuration.email;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "email")
public class SmtpSettings {
    private String server;
    private int port;
    private String senderName;
    private String senderEmail;
    private String password;
}

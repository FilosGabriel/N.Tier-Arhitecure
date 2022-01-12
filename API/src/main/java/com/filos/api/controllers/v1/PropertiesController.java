package com.filos.api.controllers.v1;

import com.filos.application.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PropertiesController {

    private final AppConfig appConfig;

    @GetMapping("/app")
    public AppConfig getAppConfig() {
        return appConfig;
    }
}

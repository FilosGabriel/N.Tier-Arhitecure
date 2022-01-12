package com.filos.application.services;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface TemplateService {
    CompletableFuture<String> getTemplateAsync(String templateName);

    String replaceInTemplate(String input, Map<String, String> replaceWords);
}

package com.filos.api.config;

import com.filos.api.annotations.web.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@Deprecated
public class ApiVersionMapping extends RequestMappingHandlerMapping {
    private final String prefix;

    public ApiVersionMapping(String prefix) {
        this.prefix = prefix;
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mapping = super.getMappingForMethod(method, handlerType);
        if (mapping == null) {
            return null;
        }

        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        if (apiVersion != null) {
            RequestCondition<?> methodCondition = getCustomMethodCondition(method);
            return createApiVersionMapping(apiVersion, methodCondition).combine(mapping);
        }

        ApiVersion typeApiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        if (typeApiVersion != null) {
            RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);
            return createApiVersionMapping(typeApiVersion, typeCondition).combine(mapping);
        }

        return mapping;
    }

    private RequestCondition<RequestMappingInfo> createApiVersionMapping(ApiVersion apiVersion, RequestCondition<?> customCondition) {
        int version = apiVersion.version();
        String[] patterns = new String[]{prefix + version};

        RequestMappingInfo.paths()
                .customCondition(customCondition)
                .build();
        return new RequestMappingInfo(
                new PatternsRequestCondition(patterns, getUrlPathHelper(), getPathMatcher(), useSuffixPatternMatch(), useTrailingSlashMatch(), getFileExtensions()),
                new RequestMethodsRequestCondition(),
                new ParamsRequestCondition(),
                new HeadersRequestCondition(),
                new ConsumesRequestCondition(),
                new ProducesRequestCondition(),
                customCondition);

    }
}

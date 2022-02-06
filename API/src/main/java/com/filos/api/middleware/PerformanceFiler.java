package com.filos.api.middleware;

import com.filos.application.services.monitoring.PerformanceMonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(2)
@Component
@ConditionalOnProperty(value = "web.rate-limiter.enabled", havingValue = "true")
@RequiredArgsConstructor
public class PerformanceFiler implements Filter {
    private final PerformanceMonitoringService monitoringService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        var requestMonitoring = PerformanceMonitoringService.RequestMonitoring.builder()
                .method(request.getMethod())
                .url(request.getRequestURI())
                .build();

        PerformanceMonitoringService.DurationMonitoring monitoring = monitoringService.startMonitoring(requestMonitoring);
        filterChain.doFilter(request, servletResponse);
        monitoringService.finishMonitoring(monitoring);
    }

}

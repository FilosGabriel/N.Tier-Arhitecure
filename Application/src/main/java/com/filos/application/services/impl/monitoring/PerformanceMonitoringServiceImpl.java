package com.filos.application.services.impl.monitoring;

import com.filos.application.services.monitoring.PerformanceMonitoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "web.rate-limiter.enabled", havingValue = "true")
public class     PerformanceMonitoringServiceImpl implements PerformanceMonitoringService {
    private final Clock serviceClock;

    @Override
    public DurationMonitoring startMonitoring(RequestMonitoring request) {
        if (log.isDebugEnabled()) {
            DurationMonitoring duration = DurationMonitoring.from(request);
            duration.setRequestId(UUID.randomUUID());
            duration.setStart(LocalDateTime.now(serviceClock));
            log.debug("New request {} {} at: {} with id=[{}]", request.getMethod(), request.getUrl(), duration.getStart(), duration.getRequestId());
            return duration;
        }
        return DurationMonitoring.DEFAULT;
    }

    @Override
    public void finishMonitoring(DurationMonitoring requestDuration) {
        if (log.isDebugEnabled()) {
            RequestMonitoring requestMonitoring = requestDuration.getRequestMonitoring();
            long between = ChronoUnit.MILLIS.between(requestDuration.getStart(), LocalDateTime.now(serviceClock));
            log.debug("Request {} {} took: {} ms with id=[{}]", requestMonitoring.getMethod(), requestMonitoring.getUrl(), between, requestDuration.getRequestId());
        }
    }
}

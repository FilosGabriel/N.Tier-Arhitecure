package com.filos.application.services.monitoring;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

public interface PerformanceMonitoringService {
    DurationMonitoring startMonitoring(RequestMonitoring request);

    void finishMonitoring(DurationMonitoring requestDuration);

    @Value
    @Builder(toBuilder = true)
    class RequestMonitoring {
        String url;
        String method;
    }

    @Setter
    @Getter
    @RequiredArgsConstructor
    class DurationMonitoring {
        public final static DurationMonitoring DEFAULT = new DurationMonitoring(null);
        private final RequestMonitoring requestMonitoring;
        private UUID requestId;
        private LocalDateTime start;

        public static DurationMonitoring from(RequestMonitoring requestMonitoring) {
            return new DurationMonitoring(requestMonitoring);
        }
    }
}

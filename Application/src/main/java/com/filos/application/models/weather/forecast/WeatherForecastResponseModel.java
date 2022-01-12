package com.filos.application.models.weather.forecast;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class WeatherForecastResponseModel {
    LocalDateTime date;
    int temperatureC;
    int temperature = 32 + (int) (temperatureC / 0.5556);
    String summary;
}

package com.filos.application.services;

import com.filos.application.models.weather.forecast.WeatherForecastResponseModel;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public interface WeatherForecastService {

    CompletableFuture<Collection<WeatherForecastResponseModel>> getAsync();
}

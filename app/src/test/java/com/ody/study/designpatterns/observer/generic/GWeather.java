package com.ody.study.designpatterns.observer.generic;

import com.ody.study.designpatterns.observer.WeatherType;
import com.ody.study.util.LoggerFactory;

/**
 *
 * GWeather
 *
 */
public class GWeather extends Observable<GWeather, Race, WeatherType> {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    private WeatherType currentWeather;

    public GWeather() {
        currentWeather = WeatherType.SUNNY;
    }

    /**
     * Makes time pass for weather
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObservers(currentWeather);
    }
}

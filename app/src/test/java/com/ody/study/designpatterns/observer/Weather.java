package com.ody.study.designpatterns.observer;

import com.ody.study.util.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Weather can be observed by implementing {@link WeatherObserver} interface and registering as
 * listener.
 *
 */
public class Weather {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    private WeatherType currentWeather;
    private List<WeatherObserver> observers;

    public Weather() {
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }

    /**
     * Makes time pass for weather
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(currentWeather);
        }
    }
}

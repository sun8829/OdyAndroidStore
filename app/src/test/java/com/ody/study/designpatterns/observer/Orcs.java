package com.ody.study.designpatterns.observer;


import com.ody.study.util.LoggerFactory;

/**
 *
 * Orcs
 *
 */
public class Orcs implements WeatherObserver {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    @Override
    public void update(WeatherType currentWeather) {
        switch (currentWeather) {
            case COLD:
                LOGGER.info("The orcs are freezing cold.");
                break;
            case RAINY:
                LOGGER.info("The orcs are dripping wet.");
                break;
            case SUNNY:
                LOGGER.info("The sun hurts the orcs' eyes.");
                break;
            case WINDY:
                LOGGER.info("The orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}

package com.ody.study.designpatterns.observer;


import com.ody.study.util.LoggerFactory;


/**
 *
 * Hobbits
 *
 */
public class Hobbits implements WeatherObserver {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    @Override
    public void update(WeatherType currentWeather) {
        switch (currentWeather) {
            case COLD:
                LOGGER.info("The hobbits are shivering in the cold weather.");
                break;
            case RAINY:
                LOGGER.info("The hobbits look for cover from the rain.");
                break;
            case SUNNY:
                LOGGER.info("The happy hobbits bade in the warm sun.");
                break;
            case WINDY:
                LOGGER.info("The hobbits hold their hats tightly in the windy weather.");
                break;
            default:
                break;
        }
    }
}

package com.ody.study.designpatterns.observer.generic;

import com.ody.study.designpatterns.observer.WeatherType;
import com.ody.study.util.LoggerFactory;

/**
 *
 * GOrcs
 *
 */
public class GOrcs implements Race {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    @Override
    public void update(GWeather weather, WeatherType weatherType) {
        switch (weatherType) {
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

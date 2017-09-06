package com.ody.study.designpatterns.observer;


import com.ody.study.designpatterns.observer.generic.GHobbits;
import com.ody.study.designpatterns.observer.generic.GOrcs;
import com.ody.study.designpatterns.observer.generic.GWeather;
import com.ody.study.util.LoggerFactory;

import org.junit.Test;

import java.util.logging.Logger;

/**
 *
 * The Observer pattern is a software design pattern in which an object, called the subject,
 * maintains a list of its dependents, called observers, and notifies them automatically of any
 * state changes, usually by calling one of their methods. It is mainly used to implement
 * distributed event handling systems. The Observer pattern is also a key part in the familiar
 * model–view–controller (MVC) architectural pattern. The Observer pattern is implemented in
 * numerous programming libraries and systems, including almost all GUI toolkits.
 * <p>
 * In this example {@link Weather} has a state that can be observed. The {@link Orcs} and
 * {@link Hobbits} register as observers and receive notifications when the {@link Weather} changes.
 *
 */
public class App {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    @Test
    public void test() {

        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();

        // Generic observer inspired by Java Generics and Collection by Naftalin & Wadler
        LOGGER.info("--Running generic version--");
        GWeather gWeather = new GWeather();
        gWeather.addObserver(new GOrcs());
        gWeather.addObserver(new GHobbits());

        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
    }
}

/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ody.study.designpatterns.singleton;

import com.ody.study.util.LoggerFactory;

import org.junit.Test;

public class App {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    /**
     * Program entry point.
     */
    @Test
    public void test() {

        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        LOGGER.info("枚举式1={}", enum1);
        LOGGER.info("枚举式2={}", enum2);

        StaticInnerClassSingleton inner1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton inner2 = StaticInnerClassSingleton.getInstance();
        LOGGER.info("静态内部类1={}", inner1);
        LOGGER.info("静态内部类2={}", inner2);

        EagerSingleton eager1 = EagerSingleton.INSTANCE;
        EagerSingleton eager2 = EagerSingleton.INSTANCE;
        LOGGER.info("饿汉式1={}", eager1);
        LOGGER.info("饿汉式2={}", eager2);

        EagerPlusSingleton eagerPlus1 = EagerPlusSingleton.getInstance();
        EagerPlusSingleton eagerPlus2 = EagerPlusSingleton.getInstance();
        LOGGER.info("升级版饿汉式1={}", eagerPlus1);
        LOGGER.info("升级版饿汉式2={}", eagerPlus1);

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        LOGGER.info("懒汉1={}", lazy1);
        LOGGER.info("懒汉2={}", lazy2);

        LazyPlusSingleton lazyPlus1 = LazyPlusSingleton.getInstance();
        LazyPlusSingleton lazyPlus2 = LazyPlusSingleton.getInstance();
        LOGGER.info("升级版懒汉1={}", lazyPlus1);
        LOGGER.info("升级版懒汉2={}", lazyPlus2);
    }
}

package com.ody.study.designpatterns.builder;

import android.support.v7.app.AlertDialog;

import com.ody.study.util.LoggerFactory;

import org.junit.Test;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class App {

    private static final LoggerFactory LOGGER = LoggerFactory.INSTANCE;

    /**
     * Program entry point
     */
    @Test
    public void test() {

        Hero mage = new Hero.Builder(Profession.MAGE, "Riobard")
                .setHairColor(HairColor.BLACK)
                .setWeapon(Weapon.DAGGER)
                .build();
        LOGGER.info(mage.toString());

        Hero warrior = new Hero.Builder(Profession.WARRIOR, "Amberjill")
                .setHairColor(HairColor.BLOND)
                .setHairType(HairType.LONG_CURLY)
                .setArmor(Armor.CHAIN_MAIL)
                .setWeapon(Weapon.SWORD)
                .build();

        LOGGER.info(warrior.toString());

        Hero thief = new Hero.Builder(Profession.THIEF, "Desmond")
                .setHairType(HairType.BALD)
                .setWeapon(Weapon.BOW)
                .build();
        LOGGER.info(thief.toString());

    }
}

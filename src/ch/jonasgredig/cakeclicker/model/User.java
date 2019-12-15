package ch.jonasgredig.cakeclicker.model;

import java.util.Arrays;
import java.util.List;

public class User {

    public static Long score = 0L;
    public static Long currentClickMultiplier = 1l;
    public static Long currentAutomaticCakesPerSercond = 0L;
    public static List<Upgradable> upgrades = Arrays.asList(
            new ClickerUpgrade("Clicker Upgrade", 1l, 1l, 1l),
            new Upgrade("Grandma", 3l, 0l, 100l, true),
            new Upgrade("Family", 33l, 0l, 10000l, false),
            new Upgrade("Factory", 400l, 0l, 1000000l, false),
            new Upgrade("Planet", 2000l, 0l, 1000000l, false)
    );


    public static Long getScore() {
        return score;
    }

    public static synchronized void setScore(Long score) {
        User.score = score;
    }

    public static Long getCurrentClickMultiplier() {
        return currentClickMultiplier;
    }

    public static void setCurrentClickMultiplier(Long currentClickMultiplier) {
        User.currentClickMultiplier = currentClickMultiplier;
    }

    public static Long getCurrentAutomaticCakesPerSercond() {
        return currentAutomaticCakesPerSercond;
    }

    public static synchronized void setCurrentAutomaticCakesPerSercond(Long currentAutomaticCakesPerSercond) {
        User.currentAutomaticCakesPerSercond = currentAutomaticCakesPerSercond;
    }

    public static List<Upgradable> getUpgrades() {
        return upgrades;
    }
}

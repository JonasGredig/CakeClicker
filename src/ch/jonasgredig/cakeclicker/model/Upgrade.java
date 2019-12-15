package ch.jonasgredig.cakeclicker.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Upgrade implements Upgradable {

    private String name;
    private long multiplier;
    private long amount;
    private long nextUpgradeCost;
    private Image image;
    public boolean shown;

    public Upgrade(String name, long multiplier, long amount, long startUpgradeCost, boolean isShown) {
        this.name = name;
        this.multiplier = multiplier;
        this.amount = amount;
        this.nextUpgradeCost = startUpgradeCost;
        this.shown = isShown;
        try {
            this.image = ImageIO.read(getClass().getResource("/res/Developer.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getNextUpgradeCost() {
        return nextUpgradeCost;
    }

    public String getName() {
        return name;
    }

    public long getMultiplier() {
        return multiplier;
    }

    public long getAmount() {
        return amount;
    }

    public Image getImage() {
        return image;
    }

    public boolean buy() {
        if (User.getScore()>=nextUpgradeCost) {
            User.setScore(User.getScore()-getNextUpgradeCost());
            User.setCurrentAutomaticCakesPerSercond(User.getCurrentAutomaticCakesPerSercond()+getMultiplier());
            nextUpgradeCost = getNextUpgradeCost()*2;
            amount++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isShown() {
        return shown;
    }

    @Override
    public void setShown(boolean b) {
        shown = true;
    }
}

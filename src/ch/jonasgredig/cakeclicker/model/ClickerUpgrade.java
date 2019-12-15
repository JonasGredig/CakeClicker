package ch.jonasgredig.cakeclicker.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ClickerUpgrade implements Upgradable {

    private String name;
    private long multiplier;
    private long amount;
    private long nextUpgradeCost;
    private Image image;

    public ClickerUpgrade(String name, long multiplier, long amount, long startUpgradeCost) {
        this.name = name;
        this.multiplier = multiplier;
        this.amount = amount;
        this.nextUpgradeCost = startUpgradeCost;
        try {
            this.image = ImageIO.read(getClass().getResource("/res/Developer.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getMultiplier() {
        return multiplier;
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public long getNextUpgradeCost() {
        return nextUpgradeCost;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public boolean buy() {
        if (User.getScore()>=nextUpgradeCost) {
            User.setScore(User.getScore()-nextUpgradeCost);
            long newClickMultiplier = User.getCurrentClickMultiplier()+1L;
            User.setCurrentClickMultiplier(newClickMultiplier);
            multiplier++;
            amount++;
            nextUpgradeCost = nextUpgradeCost * 2;

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isShown() {
        return true;
    }

    @Override
    public void setShown(boolean b) {

    }
}

package ch.jonasgredig.cakeclicker.model;

import java.awt.*;

public interface Upgradable {

    public String getName();

    public long getMultiplier();

    public long getAmount();

    public long getNextUpgradeCost();

    public Image getImage();

    public boolean buy();

    public boolean isShown();

    void setShown(boolean b);
}

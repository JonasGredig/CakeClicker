package ch.jonasgredig.cakeclicker;

import ch.jonasgredig.cakeclicker.model.User;

import java.util.concurrent.TimeUnit;

public class AutomaticCakesPerSecondThread implements Runnable {

    private ScorePanel scorePanel;

    public AutomaticCakesPerSecondThread(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    @Override
    public void run() {


    }
}

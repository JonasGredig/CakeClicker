package ch.jonasgredig.cakeclicker;

import ch.jonasgredig.cakeclicker.model.User;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ScorePanel extends JPanel implements Runnable {

    JLabel scoreLable = new JLabel("0 Cakes  ");
    JLabel multiplierLable = new JLabel("0 Cakes  ");
    JLabel automaticLable = new JLabel("0 Cakes");


    public ScorePanel() {
        updateCurrentAutomaticCakesPerSecond(0);
        updateCurrentClickMuliplier(1);
        updateScore(0);
        add(scoreLable);
        add(multiplierLable);
        add(automaticLable);
    }

    public synchronized void updateScorePanel() {
        updateScore(User.getScore());
        updateCurrentClickMuliplier(User.getCurrentClickMultiplier());
        updateCurrentAutomaticCakesPerSecond(User.getCurrentAutomaticCakesPerSercond());
    }

    private void updateScore(long score) {
        User.setScore(score);
        if (score == 1L) {
            scoreLable.setText(score + " Cake  ");
        } else {
            scoreLable.setText(score + " Cakes  ");
        }
    }
    private void updateCurrentClickMuliplier(long multiplier) {
        User.setCurrentClickMultiplier(multiplier);
        multiplierLable.setText("Click Multiplier: " + multiplier + "  ");
    }

    private void updateCurrentAutomaticCakesPerSecond(long clicksPerTick) {
        User.setCurrentAutomaticCakesPerSercond(clicksPerTick);
        automaticLable.setText("Auto CPS: " + clicksPerTick*3 + "  ");
    }

    @Override
    public void run() {
        try {
            while (true) {
                User.setScore(User.getCurrentAutomaticCakesPerSercond() + User.getScore());
                updateScorePanel();
                TimeUnit.MILLISECONDS.sleep(333);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

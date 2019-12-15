package ch.jonasgredig.cakeclicker;

import javax.swing.*;
import java.awt.*;

public class CakeClickerMainFrame extends JFrame {

    private String CAKECLICKERTITLE = "CakeClicker";

    public CakeClickerMainFrame() {
        setLayout(new BorderLayout());
        setTitle(CAKECLICKERTITLE);
        ScorePanel scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.NORTH);
        add(new UpgradePanel(scorePanel), BorderLayout.WEST);
        add(new ClickerPanel(scorePanel), BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        scorePanel.run();
    }
}

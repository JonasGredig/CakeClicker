package ch.jonasgredig.cakeclicker;

import javax.swing.*;
import java.awt.*;

public class ClickerPanel extends JPanel {

    private ClickerButton clickerButton;

    public ClickerPanel(ScorePanel scorePanel) {

        ClickerButton clickerButton = new ClickerButton(scorePanel);
        setLayout(new BorderLayout());
        add(clickerButton, BorderLayout.CENTER);




    }

}

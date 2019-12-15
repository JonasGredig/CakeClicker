package ch.jonasgredig.cakeclicker;

import ch.jonasgredig.cakeclicker.model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickerButton extends JButton {

    private Image originalImage;
    private Image image;
    private static ScorePanel scorePanel;

    public ClickerButton(ScorePanel scorePanel) {

        this.setScorePanel(scorePanel);
        try {

            originalImage = ImageIO.read(getClass().getResource("/res/Cake.png"));

            image = originalImage
                    .getScaledInstance(250, 250, 10);
            ImageIcon imageIcon = new ImageIcon(image);
            setIcon(imageIcon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                User.setScore(User.getScore()+User.getCurrentClickMultiplier());
                scorePanel.updateScorePanel();
                ClickerButton clickerButton = (ClickerButton) e.getSource();
                clickerButton.setBackground(Color.WHITE);
                Image scaledImage = clickerButton.getOriginalImage().getScaledInstance(260, 260, 0);
                clickerButton.setIcon(new ImageIcon(scaledImage));
            }

            public void mouseReleased(MouseEvent e) {
                ClickerButton clickerButton = (ClickerButton) e.getSource();
                Image originalImage = clickerButton.getOriginalImage().getScaledInstance(250, 250, 0);
                clickerButton.setIcon(new ImageIcon(originalImage));
            }
        });

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }




    public Image getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(Image originalImage) {
        this.originalImage = originalImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static ScorePanel getScorePanel() {
        return scorePanel;
    }

    public void setScorePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
    }
}

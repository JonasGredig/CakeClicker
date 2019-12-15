package ch.jonasgredig.cakeclicker;

import ch.jonasgredig.cakeclicker.model.Upgradable;
import ch.jonasgredig.cakeclicker.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpgradePanel extends JPanel {

    private final ScorePanel scorePanel;
    private JLabel upgradeTitle = new JLabel("Upgrades");
    private GridBagConstraints gbc = new GridBagConstraints();
    JPanel upgradesPanel = new JPanel();

    public UpgradePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;

        setLayout(new BorderLayout());

        updateUpgradesUI();
        add(upgradesPanel, BorderLayout.NORTH);
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public void updateUpgradesUI() {
        upgradesPanel = new JPanel();
        upgradesPanel.setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        upgradesPanel.add(new JLabel("Upgrades"), gbc);

        boolean lastUpgradeShown = true;

        for (Upgradable upgrade : User.getUpgrades()) {

            if (lastUpgradeShown) {
                JButton jButton = new JButton();
                JLabel level = new JLabel();
                JLabel upgradeCost = new JLabel();
                JPanel singleUpgradePanel = new JPanel();
                singleUpgradePanel.setLayout(new BorderLayout());

                jButton.setIcon(new ImageIcon(upgrade.getImage().getScaledInstance(25, 25, 0)));
                jButton.setText(upgrade.getName());
                level.setText("Level: " + upgrade.getAmount());
                upgradeCost.setText(" Upgrade cost: " + upgrade.getNextUpgradeCost());
                singleUpgradePanel.add(jButton, BorderLayout.NORTH);
                singleUpgradePanel.add(level, BorderLayout.WEST);
                singleUpgradePanel.add(new JLabel(), BorderLayout.CENTER);
                singleUpgradePanel.add(upgradeCost, BorderLayout.EAST);

                upgradesPanel.add(singleUpgradePanel, gbc);
                add(upgradesPanel, BorderLayout.NORTH);

                lastUpgradeShown = upgrade.isShown();

                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton upgradeButton = (JButton) e.getSource();
                        if (!upgrade.buy()) {
                            JOptionPane.showMessageDialog(null, "You dont own enough cake!");
                        } else {
                            Upgradable lastUpgrade = User.getUpgrades().get(0);
                            for (Upgradable upgrade : User.getUpgrades()) {
                                if (!upgrade.isShown() && lastUpgrade != null && lastUpgrade.getAmount() > 0 && User.getUpgrades().indexOf(upgrade) != 0) {
                                    upgrade.setShown(true);
                                    break;
                                }
                                lastUpgrade = upgrade;
                            }
                            updateUpgradesUI();
                            scorePanel.updateScorePanel();
                        }
                    }
                });

            } else {
                lastUpgradeShown = false;
            }

        }

    }
}

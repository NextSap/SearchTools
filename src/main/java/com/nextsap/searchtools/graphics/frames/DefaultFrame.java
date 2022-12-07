package com.nextsap.searchtools.graphics.frames;

import com.nextsap.searchtools.Settings;
import com.nextsap.searchtools.graphics.FrameManager;
import com.nextsap.searchtools.loader.Loader;
import com.nextsap.searchtools.objects.components.Button;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DefaultFrame extends FrameManager {

    public DefaultFrame() {
        this.setTitle(Settings.getDefaultFrameName());
        this.setWidth(300);
        this.setHeight(220);
        this.initialize();
        this.setMain(true);

        this.getPanel().setLayout(new GridBagLayout());
        this.getPanel().setBackground(Settings.getBackgroundColor());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Settings.getBackgroundColor());
        titlePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), Settings.getVersion()));
        titlePanel.setPreferredSize(new Dimension(200, 70));

        ImageIcon image = new ImageIcon(Settings.getImagePath());
        JLabel titleLabel = new JLabel(image);
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 22));
        titlePanel.add(titleLabel);

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.getPanel().add(titlePanel, constraints);

        JPanel spacerPanel = new JPanel();
        spacerPanel.setBackground(Settings.getBackgroundColor());
        spacerPanel.setPreferredSize(new Dimension(2, 20));

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.getPanel().add(spacerPanel, constraints);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Settings.getBackgroundColor());
        searchPanel.setPreferredSize(new Dimension(150, 80));

        JLabel askLabel = new JLabel(Settings.getEnterPseudo());
        searchPanel.add(askLabel);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(140, 20));
        searchPanel.add(textField);

        Button searchButton = new Button("Chercher", Color.WHITE);
        searchButton.setPreferredSize(new Dimension(120, 20));
        searchButton.addActionListener(actionEvent -> {
            try {
                String pseudo = textField.getText();

                if(pseudo.length() < 3 || pseudo.length() > 16) {
                    this.showErrorDialog(Settings.getError(), Settings.getErrorLengthPseudoMessage());
                    return;
                }

                this.showInformationDialog(Settings.getResponseTitle(), Loader.searchBannedPlayer(textField.getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        searchPanel.add(searchButton);

        constraints.gridx = 0;
        constraints.gridy = 2;
        this.getPanel().add(searchPanel, constraints);
    }
}

package com.nextsap.searchtools.graphics;

import com.nextsap.searchtools.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Class to manage JFrame classes
 *
 * @author Fallancy <3 I love him
 */

public class FrameManager {

    private JFrame frame;
    private JPanel panel;

    private String title;
    private Image favicon;
    private int width;
    private int height;
    private boolean resizable;
    private boolean main;

    /**
     * {@link FrameManager} Constructor
     */
    public FrameManager() {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.title = null;
        this.favicon = null;
        this.width = 300;
        this.height = 200;
        this.resizable = false;
        this.main = false;
    }

    /**
     * Initialize the frame
     */
    public void initialize() {
        if (this.title != null) this.frame.setTitle(this.title);
        if (this.favicon != null) this.frame.setIconImage(this.favicon);

        this.frame.setSize(this.width, this.height);
        this.frame.setResizable(this.resizable);
        this.frame.setContentPane(this.panel);
        this.frame.setIconImage(new ImageIcon(Settings.getIconPath()).getImage());
    }

    /**
     * Show the frame
     */
    public void show() {
        this.frame.setLocationRelativeTo(null);
        if (this.main) this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        else {
            this.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        }

        this.frame.setVisible(true);
    }

    /**
     * Hide the frame
     */
    public void hide() {
        this.frame.setVisible(false);
    }

    /**
     * Show an error dialog on the current frame
     *
     * @param message is the error message
     */
    public void showErrorDialog(String message) {
        showErrorDialog("Une erreur est survenue !", message);
    }

    /**
     * Show an error dialog on the current frame
     *
     * @param title   is the error's title
     * @param message is the error message
     */
    public void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(this.getFrame(), message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Show an information dialog on the current frame
     *
     * @param title   is the information's title
     * @param message is the information message
     */
    public void showInformationDialog(String title, String message) {
        JOptionPane.showMessageDialog(this.getFrame(), message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show a question dialog on the current frame
     *
     * @param title   is the question's title
     * @param message is the question message
     */
    public int showQuestionDialog(String title, String message) {
        return JOptionPane.showConfirmDialog(this.getFrame(), message, title, JOptionPane.YES_NO_OPTION);
    }

    /**
     * Show a default dialog on the current frame
     *
     * @param title   is the question's title
     * @param message is the question message
     */
    public int showDefaultDialog(String title, String message) {
        return JOptionPane.showConfirmDialog(this.getFrame(), message, title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Show an input dialog on the current frame
     *
     * @param title   is the input's title
     * @param message is the input message
     */
    public String showInputDialog(String title, String message) {
        return JOptionPane.showInputDialog(this.getFrame(), message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public String showAskLauncherDialog(String title, String message) {
        String[] options = new String[]{"AzLauncher", "BadlionClient", "LunarClient", "Minecraft"};
        int choseOption = JOptionPane.showOptionDialog(this.getFrame(), message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        if(choseOption == -1) System.exit(0);
        return options[choseOption];
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getFavicon() {
        return favicon;
    }

    public void setFavicon(Image favicon) {
        this.favicon = favicon;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
}

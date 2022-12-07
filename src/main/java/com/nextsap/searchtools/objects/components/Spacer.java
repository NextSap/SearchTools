package com.nextsap.searchtools.objects.components;

import javax.swing.*;
import java.awt.*;

public class Spacer extends JLabel {
    /**
     * Creates a <code>JLabel</code> instance with
     * no image and with an empty string for the title.
     * The label is centered vertically
     * in its display area.
     * The label's contents, once set, will be displayed on the leading edge
     * of the label's display area.
     */
    public Spacer(int width, int height) {
        this.setText("");
        this.setPreferredSize(new Dimension(width, height));
    }
}

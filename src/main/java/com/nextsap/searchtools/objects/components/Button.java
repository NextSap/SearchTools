package com.nextsap.searchtools.objects.components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String name, Color color) {
        setText(name);
        setBackground(color);
        setFocusable(false);
        setBorderPainted(false);
    }
}

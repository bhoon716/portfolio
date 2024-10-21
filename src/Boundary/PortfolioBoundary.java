package Boundary;

import Control.AppControl;

import javax.swing.*;

public class PortfolioBoundary extends JPanel {

    private final AppControl appControl;

    public PortfolioBoundary(AppControl appControl) {
        this.appControl = appControl;

        JLabel label = new JLabel("Portfolio");
        add(label);
    }
}

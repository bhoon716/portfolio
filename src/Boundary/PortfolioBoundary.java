package Boundary;

import javax.swing.*;

public class PortfolioBoundary extends JPanel {

    private final BoundaryManager manager;

    public PortfolioBoundary(BoundaryManager manager) {
        this.manager = manager;

        JLabel label = new JLabel("Portfolio");
        add(label);
    }
}

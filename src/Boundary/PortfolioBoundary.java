package Boundary;

import javax.swing.*;

public class PortfolioBoundary extends JPanel {

    private final BoundaryManager boundaryManager;

    public PortfolioBoundary(BoundaryManager boundaryManager) {
        this.boundaryManager = boundaryManager;

        JLabel label = new JLabel("Portfolio");
        add(label);
    }
}

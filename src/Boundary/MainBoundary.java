package Boundary;

import javax.swing.*;

public class MainBoundary extends JPanel {

    private final BoundaryManager manager;

    public MainBoundary(BoundaryManager manager) {
        this.manager = manager;

        JLabel label = new JLabel("Boundary");
        add(label);
    }
}

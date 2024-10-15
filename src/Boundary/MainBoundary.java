package Boundary;

import javax.swing.*;

public class MainBoundary extends JPanel {

    private final BoundaryManager boundaryManager;

    public MainBoundary(BoundaryManager boundaryManager) {
        this.boundaryManager = boundaryManager;

        JLabel label = new JLabel("Boundary");
        add(label);

    }


}

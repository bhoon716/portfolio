package Boundary;

import Control.AppControl;

import javax.swing.*;

public class MainBoundary extends JPanel {

    private final BoundaryManager boundaryManager;
    private final AppControl appControl;

    public MainBoundary(BoundaryManager boundaryManager, AppControl appControl) {
        this.boundaryManager = boundaryManager;
        this.appControl = appControl;

        JLabel label = new JLabel("Boundary");
        add(label);
    }
}

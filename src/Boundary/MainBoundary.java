package Boundary;

import Control.AppControl;
import Entity.Portfolio;

import javax.swing.*;
import java.util.List;

public class MainBoundary extends JPanel {

    private final BoundaryManager boundaryManager;
    private final AppControl appControl;

    public MainBoundary(BoundaryManager boundaryManager, AppControl appControl) {
        this.boundaryManager = boundaryManager;
        this.appControl = appControl;

        JLabel label = new JLabel("Boundary");
        add(label);

        List<Portfolio> portfolioList = appControl.getPortfolioList();
    }
}

package Boundary;

import javax.swing.*;

public class AssetBoundary extends JPanel {

    private final BoundaryManager manager;

    public AssetBoundary(BoundaryManager manager) {
        this.manager = manager;

        JLabel label = new JLabel("Asset Boundary");
        add(label);
    }
}

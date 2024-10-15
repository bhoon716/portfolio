package Boundary;

import Control.AppControl;

import javax.swing.*;
import java.awt.*;

public class StockBoundary extends JPanel {

    private final BoundaryManager boundaryManager;
    private AppControl appControl;

    public StockBoundary(BoundaryManager boundaryManager, AppControl appControl) {
        this.boundaryManager = boundaryManager;

        setSize(800, 600);
        setLayout(new FlowLayout());

        //임시
        JTextField textField = new JTextField(20);
        add(textField);

        JButton button = new JButton("switch MainBoundary");
        add(button);
    }

    public void switchMainBoundary() {
        boundaryManager.switchBoundary(new MainBoundary(this.boundaryManager, this.appControl));
    }
}

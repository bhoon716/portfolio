package Boundary;

import Logic.ApiLogic;

import javax.swing.*;
import java.awt.*;

public class BoundaryManager {

    private JFrame frame;
    private JPanel currentBoundary;

    public BoundaryManager() {
        frame = new JFrame("Portfolio Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setVisible(true);

        ApiLogic.getCurrentValue("QQQ");
    }

    public void switchBoundary(JPanel newBoundary) {
        if(currentBoundary != null){
            frame.remove(currentBoundary);
        }
        currentBoundary = newBoundary;
        frame.add(currentBoundary);
        frame.revalidate();
        frame.repaint();
        frame.pack();
        frame.setVisible(true);
    }
}

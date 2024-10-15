package Boundary;

import javax.swing.*;

public class BoundaryManager {

    private JFrame frame;
    private JPanel currentBoundary;

    public BoundaryManager() {
        frame = new JFrame("Portfolio Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    public void switchBoundary(JPanel newBoundary) {
        if(currentBoundary != null){
            frame.remove(currentBoundary);
        }
        currentBoundary = newBoundary;
        frame.add(currentBoundary);
        frame.revalidate();
        frame.repaint();
    }
}

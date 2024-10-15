package Boundary;

import javax.swing.*;

public class BounbaryManager {

    private JFrame frame;
    private JPanel currentBoundary;

    public BounbaryManager() {
        frame = new JFrame("Portfolio Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

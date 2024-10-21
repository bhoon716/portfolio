package Boundary;

import Control.AppControl;

import javax.swing.*;

public class MainBoundary extends JFrame {

    private final AppControl appControl;

    private JPanel currentPanel;

    public MainBoundary(AppControl appControl) {
        this.appControl = appControl;

        setTitle("Portfolio Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        initUI();
        updatePortfolioList();
        setVisible(true);
    }

    private void initUI() {
        currentPanel = new JPanel();

        JLabel label = new JLabel("Main Boundary");
        currentPanel.add(label);

        JButton button = new JButton("Portfolio");
        button.addActionListener(e -> appControl.showBoundary(new PortfolioBoundary(appControl)));
        currentPanel.add(button);

        add(currentPanel);
    }

    public void updatePortfolioList(){

    }

    public void switchBoundary(JPanel panel) {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = panel;
        add(panel);
        revalidate();
        repaint();
        setVisible(true);
    }
}

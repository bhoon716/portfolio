package Boundary;

import Control.AppControl;

import javax.swing.*;
import java.awt.*;

public class StockBoundary extends JPanel {

    private final AppControl appControl;

    public StockBoundary(AppControl appControl) {
        this.appControl = appControl;

        initUI();
    }

    public void initUI(){
        JLabel title = new JLabel("StockBoundary");
        add(title);

        JButton portfolioButton = new JButton("Go to portfolio view");
        portfolioButton.addActionListener(e -> appControl.showBoundary(new PortfolioBoundary(appControl)));
        add(portfolioButton);
    }

}

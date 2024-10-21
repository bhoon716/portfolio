package Control;

import Boundary.MainBoundary;
import Logic.PortfolioLogic;

import javax.swing.*;

public class AppControl {

    private final PortfolioLogic portfolioLogic;
    private MainBoundary mainBoundary;

    public AppControl(){
        this.portfolioLogic = new PortfolioLogic();
    }

    public void showBoundary(JPanel panel){
        mainBoundary.switchBoundary(panel);
    }

    public void showMainBoundary(){
        mainBoundary = new MainBoundary(this);
    }
}

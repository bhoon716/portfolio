package Control;


import Entity.Portfolio;
import Logic.PortfolioManager;

import java.util.List;

public class AppControl {

    private final PortfolioManager portfolioManager;

    public AppControl(PortfolioManager portfolioManager) {
        this.portfolioManager = portfolioManager;
    }

    public void addPortfolio(String name) {
        portfolioManager.addPortfolio(name);
    }

    public List<Portfolio> getPortfolios(){
        return portfolioManager.getPortfolios();
    }
}

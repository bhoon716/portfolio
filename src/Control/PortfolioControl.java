package Control;

import Logic.PortfolioLogic;
import Entity.Asset;
import Entity.Portfolio;

import java.util.List;

public class PortfolioControl {

    private final PortfolioLogic portfolioLogic;

    public PortfolioControl(PortfolioLogic portfolioLogic) {
        this.portfolioLogic = portfolioLogic;
    }

    public void addAssetToPortfolio(String portfolioName, Asset asset) {
        Portfolio portfolio = portfolioLogic.getPortfolioByName(portfolioName);
        if (portfolio != null) {
            portfolio.addAsset(asset);
        }
    }

    public void removeAssetFromPortfolio(String portfolioName, Asset asset) {
        Portfolio portfolio = portfolioLogic.getPortfolioByName(portfolioName);
        if (portfolio != null) {
            portfolio.removeAsset(asset);
        }
    }

    public Portfolio getPortfolio(String portfolioName) {
        return portfolioLogic.getPortfolioByName(portfolioName);
    }

    public void createPortfolio(String name) {
        portfolioLogic.createPortfolio(name);
    }

    public void deletePortfolio(String name) {
        portfolioLogic.deletePortfolio(name);
    }

    // Add this public method to access the list of portfolios
    public List<Portfolio> getPortfolioList() {
        return portfolioLogic.getPortfolioList();
    }
}

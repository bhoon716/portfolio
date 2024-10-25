package Logic;

import Entity.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioLogic {

    private List<Portfolio> portfolios;

    public PortfolioLogic() {
        this.portfolios = new ArrayList<>();
    }

    public void createPortfolio(String name) {
        portfolios.add(new Portfolio(name));
    }

    public Portfolio getPortfolioByName(String name) {
        for (Portfolio portfolio : portfolios) {
            if (portfolio.getName().equals(name)) {
                return portfolio;
            }
        }
        return null;
    }

    public List<Portfolio> getPortfolioList() {
        return portfolios;
    }

    public void deletePortfolio(String name) {
        portfolios.removeIf(p -> p.getName().equals(name));
    }
}

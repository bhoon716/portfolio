package Control;

import Entity.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class AppControl {

    private List<Portfolio> portfolioList;

    public AppControl() {
        this.portfolioList = new ArrayList<>();
    }

    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }
}

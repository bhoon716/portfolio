package Logic;

import Entity.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioManager {

    private static List<Portfolio> portfolios;

    public PortfolioManager(){
        this.portfolios = new ArrayList<>();
    }

    public void addPortfolio(String name){
        portfolios.add(new Portfolio(name));
    }

    public List<Portfolio> getPortfolios(){
        return portfolios;
    }

    public Portfolio getPortfolioByName(String name){
        Portfolio result = null;
        for(Portfolio p : portfolios){
            if(p.getName().equals(name)){
                result = p;
                break;
            }
        }
        return result;
    }

}

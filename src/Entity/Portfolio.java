package Entity;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private List<Asset> assets;

    public Portfolio(String name) {
        this.name = name;
        this.assets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAsset(Asset asset) {
        this.assets.add(asset);
    }

    public void removeAsset(Asset asset) {
        this.assets.remove(asset);
    }

    public List<Asset> getAllAsset(){
        return this.assets;
    }

    public Double calculatePortfolioValue() {
        double totalValue = 0;
        for (Asset asset : assets) {
            totalValue += asset.getValue();
        }
        return totalValue;
    }
}

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

    public List<Asset> getAssets() {
        return assets;
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public void removeAsset(Asset asset) {
        assets.remove(asset);
    }

    public double getTotalValue() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.getAveragePrice();
        }
        return total;
    }

    // Additional methods for profit/loss calculations
}

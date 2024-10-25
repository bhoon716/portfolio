package Logic;// ApplicationLogic.AssetManager.java

import Entity.*;

public class AssetLogic {

    public AssetLogic(){
    }

    public Asset getAssetInfo(AssetType type, String symbol, double averagePrice, double quantity){
        switch (type) {
            case STOCK:
                return new Stock(symbol, averagePrice, quantity);
            case CRYPTOCURRENCY:
                return new Cryptocurrency(symbol, averagePrice, quantity);
            case CASH:
                return new Cash(symbol, 0); // Entity.Cash amount can be set later
            default:
                throw new IllegalArgumentException("Unsupported asset type");
        }
    }
}

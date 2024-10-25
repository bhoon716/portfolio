package Control;// Control.AssetController.java

import Entity.Asset;
import Entity.AssetInfo;
import Entity.AssetType;
import Logic.ApiService;
import Logic.AssetLogic;

import java.io.IOException;

public class AssetControl {

    private final AssetLogic assetLogic;

    public AssetControl(AssetLogic assetLogic) {
        this.assetLogic = assetLogic;
    }

    public Asset searchAsset(AssetType type, String symbol, double averagePrice, double quantity) throws IOException {
        return assetLogic.getAssetInfo(type, symbol, averagePrice, quantity);
    }

    public AssetInfo getAssetInfo(AssetType type, String symbol) throws Exception {
        switch (type) {
            case STOCK:
                return ApiService.getStockInfoBySymbol(symbol);
            case CRYPTOCURRENCY:
                return ApiService.getCryptoInfoBySymbol(symbol);
            case CASH:
                return null; // Entity.Cash amount can be set later
            default:
                throw new IllegalArgumentException("Unsupported asset type");
        }
    }
}

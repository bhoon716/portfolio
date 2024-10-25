package Entity;

public interface Asset {

    AssetType getAssetType();

    String getSymbol();

    double getEvaluation();

    double getQuantity();

    double getPrice();

    double getAveragePrice();

    double getProfitLoss();

    double getChange();
}

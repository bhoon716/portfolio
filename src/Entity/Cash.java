package Entity;

public class Cash implements Asset {
    private String symbol;
    private double quantity;

    public Cash(String symbol, double quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
    }

    @Override
    public AssetType getAssetType() {
        return AssetType.CASH;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getEvaluation() {
        return quantity;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getAveragePrice() {
        return 0;
    }

    @Override
    public double getProfitLoss() {
        return 0;
    }

    @Override
    public double getChange() {
        return 0;
    }
}

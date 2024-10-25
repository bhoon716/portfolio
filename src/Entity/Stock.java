package Entity;

import Logic.ApiService;

public class Stock implements Asset {
    private String symbol;
    private double averagePrice;  // 매입 평균 가격
    private double price;         // 현재 가격
    private double quantity;      // 보유 수량

    public Stock(String symbol, double averagePrice, double quantity) {
        this.symbol = symbol;
        this.averagePrice = averagePrice;
        this.quantity = quantity;
        this.price = ApiService.getCurrentStockPrice(symbol);
    }

    public Stock(String symbol) {
        this.symbol = symbol;
        this.price = ApiService.getCurrentStockPrice(symbol);
    }

    public Stock() {
    }

    @Override
    public AssetType getAssetType() {
        return AssetType.STOCK;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getEvaluation() {
        return quantity * getPrice();
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        price = ApiService.getCurrentStockPrice(symbol);
        return price;
    }

    @Override
    public double getAveragePrice() {
        return averagePrice;
    }

    @Override
    public double getProfitLoss() {
        return getEvaluation() - (averagePrice * quantity);
    }

    @Override
    public double getChange() {
        return (getPrice() - getAveragePrice()) / getAveragePrice() * 100;
    }
}

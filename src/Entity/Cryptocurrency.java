package Entity;

import Logic.ApiService;

public class Cryptocurrency implements Asset {
    private String symbol;
    private double averagePrice;  // 매입 시의 평균 단가
    private double price;         // 현재 가격
    private double quantity;      // 보유 수량

    public Cryptocurrency(String symbol, double averagePrice, double quantity) {
        this.symbol = symbol;
        this.averagePrice = averagePrice;
        this.price = ApiService.getCurrentCryptoPrice(symbol);
        this.quantity = quantity;
    }

    public Cryptocurrency(String symbol) {
        this.symbol = symbol;
        this.price = ApiService.getCurrentCryptoPrice(symbol);
    }

    @Override
    public AssetType getAssetType() {
        return AssetType.CRYPTOCURRENCY;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getEvaluation() {
        // 평가 금액 = 현재 가격 * 수량
        return quantity * getPrice();
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        price = ApiService.getCurrentCryptoPrice(symbol);
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

package Entity;

public abstract class Asset {
    private String symbol;       // 자산의 심볼 (e.g., AAPL, BTC)
    private Double quantity;     // 보유한 수량
    private Double purchasePrice;
    private Double currentPrice;

    public Asset(String symbol, Double quantity, Double purchasePrice, Double currentPrice) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    public abstract Double getValue();
}

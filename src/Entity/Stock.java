package Entity;

public class Stock extends Asset{

    public Stock(String symbol, Double quantity, Double purchasePrice, Double currentPrice) {
        super(symbol, quantity, purchasePrice, currentPrice);
    }

    @Override
    public Double getValue() {
        return 0.0;
    }

}

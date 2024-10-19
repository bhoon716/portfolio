package Entity;

import Logic.ApiLogic;

public class Stock extends Asset{

    public Stock(String symbol, Double quantity, Double purchasePrice, Double currentPrice) {
        super(symbol, quantity, purchasePrice, currentPrice);
    }

    @Override
    public Double getValue() {
        return ApiLogic.getCurrentValue(getSymbol());
    }

}

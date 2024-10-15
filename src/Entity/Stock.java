package Entity;

public class Stock extends Asset{

    private Double amount;
    private Double purchasePrice;

    public Stock(String symbol){
        super(symbol);
    }

    @Override
    public Double getValue() {
        return 0.0;
    }
}

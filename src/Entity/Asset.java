package Entity;

public abstract class Asset {

    protected String symbol;

    public Asset(String name) {
        this.symbol = name;
    }

    public String getSymbol(){
        return symbol;
    };

    public abstract Double getValue();
}

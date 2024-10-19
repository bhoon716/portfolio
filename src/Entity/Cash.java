package Entity;

public class Cash extends Asset{

    public Cash(String symbol){
        super(symbol);
    }

    @Override
    public Double getValue() {
        return 0.0;
    }
}

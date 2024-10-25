package Entity;

public class StockInfo implements AssetInfo{

    private String symbol;
    private String timestamp;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;

    public StockInfo(String symbol, String timestamp, Double open, Double high, Double low, Double close, Double volume) {
        this.symbol = symbol;
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public Double getOpen() {
        return open;
    }

    @Override
    public Double getHigh() {
        return high;
    }

    @Override
    public Double getLow() {
        return low;
    }

    @Override
    public Double getClose() {
        return close;
    }

    @Override
    public Double getVolume() {
        return volume;
    }
}

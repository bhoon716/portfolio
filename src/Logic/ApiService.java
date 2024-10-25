package Logic;

import Entity.AssetInfo;
import Entity.Cryptocurrency;
import Entity.Stock;
import Entity.StockInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    // 주식 데이터 관련 API 엔드포인트
    private static final String STOCK_BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY";
    private static final String STOCK_API_KEY = "QZVB9RQC5EPHLKZX";

    // 암호화폐 데이터 관련 API 엔드포인트
    private static final String CRYPTO_BASE_URL = "https://api.coingecko.com/api/v3/simple/price";

    // 주식 데이터를 가져오는 메서드
    public static Stock fetchStockData(String symbol) {
        double price = getCurrentStockPrice(symbol);
        double averagePrice = 1.5; // Replace with actual API response (매입 평균 가격)
        return new Stock(symbol, averagePrice, price);
    }

    // 암호화폐 데이터를 가져오는 메서드
    public static Cryptocurrency fetchCryptoData(String symbol) {
        double averagePrice = 1.0; // 암호화폐 매입 평균 가격
        double quantity = 0.0;     // 암호화폐 수량 (추가 필요 시)
        return new Cryptocurrency(symbol, averagePrice, quantity);
    }

    public static Stock searchStockData(String symbol) {
        Stock stock = new Stock();
        return stock;
    }

    // 암호화폐 데이터를 가져오는 메서드
    public static Cryptocurrency searchCryptoData(String symbol) {
        double averagePrice = 1.0; // 암호화폐 매입 평균 가격
        double quantity = 0.0;     // 암호화폐 수량 (추가 필요 시)
        return new Cryptocurrency(symbol, averagePrice, quantity);
    }

    // 주식 데이터에 대한 API 요청을 수행하는 메서드
    private static String sendStockApiRequest(String symbol) throws Exception {
        String urlString = STOCK_BASE_URL + "&symbol=" + symbol + "&outputsize=1&apikey=" + STOCK_API_KEY + "&datatype=csv";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            reader.readLine(); // 헤더 스킵
            return reader.readLine(); // 실제 데이터 반환
        } finally {
            connection.disconnect();
        }
    }

    // 암호화폐 데이터에 대한 API 요청을 수행하는 메서드
    private static String sendCryptoApiRequest(String symbol) throws Exception {
        String urlString = CRYPTO_BASE_URL + "?ids=" + symbol + "&vs_currencies=usd";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString(); // JSON 응답 반환
        } finally {
            connection.disconnect();
        }
    }

    // 현재 주식 가격을 가져오는 메서드
    public static Double getCurrentStockPrice(String symbol) {
        try {
            String inputLine = sendStockApiRequest(symbol);

            if (inputLine != null) {
                // CSV 형식으로 받은 데이터를 처리
                String[] data = inputLine.split(",");
                if (data.length > 1) {
                    // CSV의 두 번째 컬럼이 가격 (0: timestamp, 1: open, 2: high, 3: low, 4: close, 5: volume)
                    return Double.parseDouble(data[1]);
                }
            }

            return 0.0; // 데이터가 없을 경우 기본값 반환
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0; // 예외 발생 시 -1.0 반환
        }
    }

    // 현재 암호화폐 가격을 가져오는 메서드
    public static double getCurrentCryptoPrice(String symbol) {
        try {
            String response = sendCryptoApiRequest(symbol.toLowerCase());

            // 예시: {"bitcoin":{"usd":50000}}
            if (response.contains(symbol)) {
                String[] parts = response.split(":");
                return Double.parseDouble(parts[2].replaceAll("[^0-9.]", "")); // 가격 정보 파싱
            }
            return 0.0; // 데이터가 없을 경우 기본값 반환
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0; // 예외 발생 시 -1.0 반환
        }
    }

    public static StockInfo getStockInfoBySymbol(String symbol) throws Exception {
        try {
            String inputLine = sendStockApiRequest(symbol);

            if (inputLine != null) {
                // CSV 형식으로 받은 데이터를 처리
                String[] data = inputLine.split(",");

                if(data.length > 1){
                    String timestamp = data[0];
                    Double open = Double.parseDouble(data[1]);
                    Double high = Double.parseDouble(data[2]);
                    Double low = Double.parseDouble(data[3]);
                    Double close = Double.parseDouble(data[4]);
                    Double volume = Double.parseDouble(data[5]);

                    StockInfo stockInfo = new StockInfo(symbol, timestamp, open, high, low, close, volume);
                    return stockInfo;
                }
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // 예외 발생 시 -1.0 반환
        }
    }

    public static AssetInfo getCryptoInfoBySymbol(String symbol) {
        return null;
    }
}

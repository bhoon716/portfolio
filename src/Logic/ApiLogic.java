package Logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiLogic {

    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY";
    private static final String API_KEY = "QZVB9RQC5EPHLKZX";

    // API 요청을 수행하는 메서드
    private static String sendApiRequest(String symbol) throws Exception {
        String urlString = BASE_URL + "&symbol=" + symbol + "&outputsize=1&apikey=" + API_KEY + "&datatype=csv";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // try-with-resources로 BufferedReader 사용
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            reader.readLine(); // 헤더 스킵
            return reader.readLine(); // 실제 데이터 반환
        } finally {
            connection.disconnect();
        }
    }

    // 현재 주식 가격을 가져오는 메서드
    public static Double getCurrentValue(String symbol) {
        try {
            String inputLine = sendApiRequest(symbol);

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
}

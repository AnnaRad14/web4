package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {

            String url =
                    "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

            String json = performRequest(url);

            Gson gson =
                    new GsonBuilder().create();

            Currency[] currencies =
                    gson.fromJson(json, Currency[].class);

            System.out.println(
                    "=== ПОТОЧНИЙ КУРС ВАЛЮТ НБУ ==="
            );

            for (Currency currency : currencies) {

                if (currency.getCc().equals("USD") ||
                        currency.getCc().equals("EUR") ||
                        currency.getCc().equals("GBP")) {

                    System.out.println(
                            currency.getCc() +
                                    " (" +
                                    currency.getTxt() +
                                    ") = " +
                                    currency.getRate() +
                                    " грн"
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Помилка при отриманні курсу валют:"
            );

            e.printStackTrace();
        }
    }

    private static String performRequest(String urlString)
            throws Exception {

        URL url =
                new URL(urlString);

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty(
                "Accept",
                "application/json"
        );

        StringBuilder result =
                new StringBuilder();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        connection.getInputStream()
                                )
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                result.append(line);
            }

        } finally {

            connection.disconnect();
        }

        return result.toString();
    }
}
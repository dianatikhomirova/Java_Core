package lesson7.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDateTime;


public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "QcvHZWShlijFPkcxV1JI7t9UEJKOWYmU";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                String dateTimeStr = objectMapper.readTree(weatherResponse).at("/DailyForecasts/0/Date").asText().split("\\+")[0];
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
                String text = objectMapper.readTree(weatherResponse).at("/Headline/Text").asText();
                String tempMin = objectMapper.readTree(weatherResponse).at("/DailyForecasts/0/Temperature/Minimum/Value").asText();
                String tempMax = objectMapper.readTree(weatherResponse).at("/DailyForecasts/0/Temperature/Maximum/Value").asText();

                System.out.printf("| В городе %s на дату %s ожидается %s, температура - %s-%s F |\n", selectedCity, dateTime.toLocalDate(), text, tempMin, tempMax);
                break;
            case FIVE_DAYS:
                HttpUrl httpUrlFive = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestFive = new Request.Builder()
                        .url(httpUrlFive)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFive).execute();
                String weatherResponse5 = fiveDayForecastResponse.body().string();

                for (int i = 0; i < 5; i++) {
                    dateTimeStr = objectMapper.readTree(weatherResponse5).at(String.format("/DailyForecasts/%d/Date", i)).asText().split("\\+")[0];
                    dateTime = LocalDateTime.parse(dateTimeStr);
                    text = objectMapper.readTree(weatherResponse5).at(String.format("/DailyForecasts/%d/Day/IconPhrase", i)).asText();
                    tempMin = objectMapper.readTree(weatherResponse5).at(String.format("/DailyForecasts/%d/Temperature/Minimum/Value", i)).asText();
                    tempMax = objectMapper.readTree(weatherResponse5).at(String.format("/DailyForecasts/%d/Temperature/Maximum/Value", i)).asText();

                    System.out.printf("| В городе %s на дату %s ожидается %s, температура - %s-%s F |\n", selectedCity, dateTime.toLocalDate(), text, tempMin, tempMax);
                }

                break;
        }
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}

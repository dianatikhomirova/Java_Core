package lesson6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Homework {
    private final static String URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/294021?apikey=QcvHZWShlijFPkcxV1JI7t9UEJKOWYmU";

    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());

        String body = response.body().string();
        System.out.println(body);
    }
}

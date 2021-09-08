package pogoda;


import com.google.gson.Gson;
import model.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherUtil {

    public static Response getWeatherFromCity(String city) throws IOException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=f896915e4f2e4765f254632549b41209");

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        Gson gson = new Gson();
        Response response = gson.fromJson(bufferedReader, Response.class);
        return response;
    }

    public static Response getWeatherFromLocation() throws IOException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=40.805798&lon=69.18389&appid=f896915e4f2e4765f254632549b41209");

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        Gson gson = new Gson();
        Response response = gson.fromJson(bufferedReader, Response.class);
        return response;
    }

}


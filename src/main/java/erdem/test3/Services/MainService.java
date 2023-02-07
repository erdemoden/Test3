package erdem.test3.Services;

import erdem.test3.Responses.WeatherResponse;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
@Service
public class MainService {
@Value("${api.key}")
private String accessKey;
    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = new WeatherResponse();
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://api.weatherstack.com/current?access_key="+accessKey+"&query="+city))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(getRequest, BodyHandlers.ofString());
            JSONObject object = new JSONObject(response.body());
            JSONObject location = object.getJSONObject("location");
            JSONObject current = object.getJSONObject("current");
            if(location!=null&&current!=null) {
                weatherResponse.setTemp(current.get("temperature").toString());
                weatherResponse.setTime(location.get("localtime").toString());
                return weatherResponse;
            }
            weatherResponse.setError("Your City Is Wron Please Check It");
            return weatherResponse;
        } catch (URISyntaxException | IOException | InterruptedException | JSONException e) {
            weatherResponse.setError("Something Went Wrong");
            return weatherResponse;
        }
    }
}

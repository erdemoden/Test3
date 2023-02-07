package erdem.test3.Responses;

import lombok.Data;

@Data
public class WeatherResponse {
    private String temp;
    private String time;
    private String error;
}

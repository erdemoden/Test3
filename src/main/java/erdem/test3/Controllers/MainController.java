package erdem.test3.Controllers;

import erdem.test3.Responses.WeatherResponse;
import erdem.test3.Services.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class MainController {
private final MainService mainService;
    @GetMapping()
    public WeatherResponse getWeather(@RequestParam String city){
        return mainService.getWeather(city);
    }
}

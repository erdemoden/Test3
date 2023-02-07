package erdem.test3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class HtmlController {

    @GetMapping
    public String getTemperature(Model model){
        return "temperature";
    }
}

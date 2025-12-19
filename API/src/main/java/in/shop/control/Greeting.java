package in.shop.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class Greeting {

    @GetMapping
    public String greeting(String name) {
        name = "hi welcome to apigateway";
        return name.toUpperCase();
    }
}

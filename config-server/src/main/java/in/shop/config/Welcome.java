package in.shop.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wel")
public class Welcome {

    @GetMapping
    public String welcome(String msg){

        msg="welcome to API Gateway Service";
        return msg;
    }


}

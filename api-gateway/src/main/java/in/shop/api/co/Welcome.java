package in.shop.api.co;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wel")
public class Welcome {

    @GetMapping("/wel")
    public String welcome(String msg){

        msg=" WELCOME  to Users-API Gateway Service please Register or Login ";
        return msg;
    }


}

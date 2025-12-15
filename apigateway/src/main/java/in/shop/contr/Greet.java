package in.shop.contr;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Greet {

    @GetMapping("/wel")
    public ResponseEntity<String> greet(String name) {
        name =" Welcome to APIGateway Service";
        return ResponseEntity.ok(name);
    }
}

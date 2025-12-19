package in.shop.contr;

import in.shop.model.Request;
import in.shop.model.Response;
import in.shop.servc.UserAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop/user/auth")
@RequiredArgsConstructor
@Log4j2
public class UserAuthController {

    private final UserAuthService userAuthService;

    @PostMapping("/reg")
    public ResponseEntity<Response> registerUser(@Valid @RequestBody Request request) {
        log.info("Registering user"+request.toString());
        Response response = userAuthService.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public  ResponseEntity<String> loginUser(@Valid @RequestBody Request request) {
        log.info("Login user"+request.toString());
        String user = userAuthService.loginUser(request);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/wel")
    public String wel(String message) {
        message = "Welcome to User Service";
        return "Hi Users  "+message;
    }

}

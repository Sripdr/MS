package in.shop.cont;

import in.shop.dto.Req;
import in.shop.dto.Res;
import in.shop.dto.UserRequest;
import in.shop.dto.UserResponse;
import in.shop.entity.UserInfo;
import in.shop.map.Mapping;
import in.shop.serv.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.awt.SystemColor.info;

@RestController
@RequestMapping("/user/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final Mapping mapping;
    private final ModelMapper modelMapper;

    @PostMapping("/reg")
    public ResponseEntity<Res> registerUser(Req req) {
        //UserInfo info = mapping.userInfo(req);
        UserInfo map = modelMapper.map(req, UserInfo.class);
        UserInfo register = userAuthService.register(map);
        Res userResponse = mapping.response(register);
        return new  ResponseEntity<>(userResponse, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(Req req) {
        //UserInfo info = mapping.loginUser(req);
        UserInfo map = modelMapper.map(req, UserInfo.class);
        String login = userAuthService.login(map);
        return ResponseEntity.ok(login);
    }

}

package in.shop.contr;

import in.shop.model.Response;
import in.shop.sec.UserFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop/user/find")
@RequiredArgsConstructor
public class UserFindController {

    private final UserFindService  userFindService;

    @GetMapping("/firstName/{userFirstName}")
    public ResponseEntity<Response> findUserByUserFirstNme(@PathVariable String userFirstName){
        Response byUserFirstName = userFindService.findByUserFirstName(userFirstName);
        return ResponseEntity.ok(byUserFirstName);
    }

    @GetMapping("/Id/{userId}")
    public ResponseEntity<Response> findByUserId(@PathVariable Integer userId){
        Response byUserId = userFindService.findByUserId(userId);
        return ResponseEntity.ok(byUserId);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Response> findByUsername(@PathVariable String username){
        Response response = userFindService.getUsername(username);
        return ResponseEntity.ok(response);
    }
}

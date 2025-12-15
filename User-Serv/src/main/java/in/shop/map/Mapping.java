package in.shop.map;

import in.shop.dto.Req;
import in.shop.dto.Res;
import in.shop.dto.UserRequest;
import in.shop.dto.UserResponse;
import in.shop.entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    public UserInfo  userInfo(Req req) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserFirstName(req.userFirstName());
        userInfo.setUserLastName(req.userLastName());
        userInfo.setUsername(req.username());
        userInfo.setPassword(req.password());
        userInfo.setRole(req.role());

        return userInfo;
    }

    public UserInfo loginUser(Req req) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(req.username());
        userInfo.setPassword(req.password());
        return userInfo;
    }

    public Res response(UserInfo userInfo) {
      return   new Res(userInfo.getUserId(),userInfo.getUserFirstName(), userInfo.getUserLastName(), userInfo.getUsername(), userInfo.getRole());
    }

}

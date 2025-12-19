package in.shop.map;

import in.shop.entity.UserInfo;
import in.shop.model.Request;
import in.shop.model.Response;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public static UserInfo mapUser(Request request) {
        UserInfo userInfo = new UserInfo();

        userInfo.setUserFirstName(request.userFirstName());
        userInfo.setUserLastName(request.userLastName());
        userInfo.setUsername(request.username());
        userInfo.setPassword(request.password());
        userInfo.setUserRole(request.userRole());
        return userInfo;
    }

    public static UserInfo login(Request request) {

        UserInfo userInfo = new UserInfo();

        userInfo.setUsername(request.username());
        userInfo.setPassword(request.password());
        return userInfo;

    }

    public static Response mapResponse(UserInfo userInfo) {
       return new Response(userInfo.getUserId(), userInfo.getUserFirstName(), userInfo.getUserLastName(), userInfo.getUsername(), userInfo.getUserRole());
    }
}

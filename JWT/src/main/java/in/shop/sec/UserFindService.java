package in.shop.sec;

import in.shop.entity.UserInfo;
import in.shop.exception.InValidUser;
import in.shop.exception.UserNotFound;
import in.shop.map.Mapper;
import in.shop.model.Response;
import in.shop.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFindService {

    private  final UserRepo userRepo;

    public Response getUsername(String username) {
        UserInfo userInfo = userRepo.findByUsername(username)
                .orElseThrow(() -> new InValidUser("Username not found with given username : " + username));
        return Mapper.mapResponse(userInfo);
    }

    public Response findByUserId(Integer userId) {

        UserInfo byId = userRepo.findById(userId).orElseThrow(()->new UserNotFound("User not found with given userId : " + userId));
        return Mapper.mapResponse(byId);

}

public Response findByUserFirstName(String userFirstName) {

       UserInfo fist= userRepo.findByUserFirstName(userFirstName).orElseThrow(()-> new UserNotFound("User not found with given userFirstName : " + userFirstName));

    return Mapper.mapResponse(fist);
}
}

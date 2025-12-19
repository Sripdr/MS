package in.shop.servc;

import in.shop.entity.UserInfo;
import in.shop.exception.InValidUser;
import in.shop.exception.UserExist;
import in.shop.map.Mapper;
import in.shop.model.Request;
import in.shop.model.Response;
import in.shop.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public Response registerUser(Request request) {
        UserInfo userInfo = Mapper.mapUser(request);
        if (userRepo.findByUsername(userInfo.getUsername()).isPresent()) {
            throw new UserExist("The User Already Exist in Database");
        }
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo save = userRepo.save(userInfo);
        return Mapper.mapResponse(save);

    }

    public String loginUser(Request request) {
        UserInfo userInfo = Mapper.login(request);
        if (userInfo.getUsername()!=null &&userInfo.getPassword()!=null) {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword()));
            if (!authenticate.isAuthenticated())
                throw new InValidUser("Invalid username or password for the User : "+userInfo.getUsername());

        }
        return LocalDateTime.now()+ " \n Welcome :  "+userInfo.getUsername().toUpperCase() +"\n You Are Authenticated";
    }

}

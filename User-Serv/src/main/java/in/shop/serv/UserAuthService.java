package in.shop.serv;

import in.shop.entity.UserInfo;
import in.shop.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class UserAuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserAuthService(UserRepo userRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserInfo register(UserInfo userIn) {
        if(userIn.getPassword()==null) {
            throw new RuntimeException("the given password for user is null");
        }
        log.info("the password is "+userIn.getPassword());
        userIn.setPassword(passwordEncoder.encode(userIn.getPassword()));
return userRepo.save(userIn);

    }

    public String login(UserInfo user) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));



        if(authenticate.isAuthenticated())
            return LocalDateTime.now() + "\n Welcome User :"+user.getUsername()+"\n You Are Authenticated";
        throw new RuntimeException("Invalid username and password");
    }
}

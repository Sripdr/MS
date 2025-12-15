package in.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userFirstName;
    private String userLastName;
    private String username;
    private String userPassword;
    private String role;
}

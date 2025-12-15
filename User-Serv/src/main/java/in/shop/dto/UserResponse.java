package in.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private String username;
    private String role;
}

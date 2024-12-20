package THS.dev.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String userName;
    private String address;
    private String email;
    private String mNumber;
}

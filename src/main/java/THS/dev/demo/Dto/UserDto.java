package THS.dev.demo.Dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    @Id
    private ObjectId Id;
    private String userName;
    private String address;
    private String email;
    private String mNumber;
}

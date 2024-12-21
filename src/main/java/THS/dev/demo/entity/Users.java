package THS.dev.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
@AllArgsConstructor
public class Users {
    @Id
    private int userId;
    private String userName;
    private String address;
    private String email;
    private String mNumber;
    private String sex;
    private String occupation;
}

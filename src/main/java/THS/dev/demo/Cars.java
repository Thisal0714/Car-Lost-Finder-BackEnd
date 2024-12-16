package THS.dev.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
@Data
@AllArgsConstructor
public class Cars {

    @Id
    private ObjectId id;
    private String image;
    private String title;
    private String start_production;
}
package THS.dev.demo.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import THS.dev.demo.entity.Users;


@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId>{

}

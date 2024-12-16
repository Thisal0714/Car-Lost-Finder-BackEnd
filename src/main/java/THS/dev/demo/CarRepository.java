package THS.dev.demo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends MongoRepository<Cars, ObjectId> {
}
package CarFinder.dev.LostCarFinder.Repositories;

import CarFinder.dev.LostCarFinder.Entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review,String> {
}

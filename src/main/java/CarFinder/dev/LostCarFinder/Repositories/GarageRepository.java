package CarFinder.dev.LostCarFinder.Repositories;

import CarFinder.dev.LostCarFinder.Entity.Garage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GarageRepository extends MongoRepository<Garage,String> {
}

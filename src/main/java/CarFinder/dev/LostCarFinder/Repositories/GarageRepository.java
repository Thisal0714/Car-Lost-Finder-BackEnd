package CarFinder.dev.LostCarFinder.Repositories;

import CarFinder.dev.LostCarFinder.Entity.Garage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GarageRepository extends MongoRepository<Garage,String> {

    List<Garage> findByGarageHome(String garageHome);

    List<Garage> findByOwnerId(String ownerId);
}

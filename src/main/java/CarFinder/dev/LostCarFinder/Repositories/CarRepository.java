package CarFinder.dev.LostCarFinder.Repositories;

import CarFinder.dev.LostCarFinder.Entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String> {

}

package CarFinder.dev.LostCarFinder.Repositories;

import CarFinder.dev.LostCarFinder.Entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends MongoRepository<Car,String> {

    List<Car> findByOwnerId(String ownerId);
    Optional<Car> findByVehicleNumber(String carId);
    List<Car> findByStatus(String status);

}

package CarFinder.dev.LostCarFinder.Repositories;

import CarFinder.dev.LostCarFinder.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(String userId);

    void deleteById(Integer userId);
}

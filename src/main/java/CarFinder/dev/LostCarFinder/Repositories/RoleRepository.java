package CarFinder.dev.LostCarFinder.Repositories;
import CarFinder.dev.LostCarFinder.Entity.ERole;
import CarFinder.dev.LostCarFinder.Entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface RoleRepository extends MongoRepository<Role, String> {
        Optional<Role> findByName(ERole name);
    }

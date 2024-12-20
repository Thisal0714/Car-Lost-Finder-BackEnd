package THS.dev.demo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import THS.dev.demo.entity.Users;

public interface UserRepository extends MongoRepository<Users,Integer>{

}

package THS.dev.demo;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;
    public List<Cars> allcars(){

        return carRepository.findAll();
    }

    public Optional<Cars> SingleCar(ObjectId id){
        return carRepository.findById(id);
    }
}
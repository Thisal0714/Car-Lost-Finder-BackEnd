package THS.dev.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @GetMapping
    public ResponseEntity<List<Cars>> getallCars(){
        return new ResponseEntity<List<Cars>>(carService.allcars(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cars>> getSingleCar(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Cars>>(carService.SingleCar(id),HttpStatus.OK);
    }
}
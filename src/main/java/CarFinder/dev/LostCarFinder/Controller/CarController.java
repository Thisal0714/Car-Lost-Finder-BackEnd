package CarFinder.dev.LostCarFinder.Controller;


import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Dto.ResponseDto;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/registerCar")
    public ResponseEntity<CarDto> registerCar(@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.registerCar(carDto));
    }
}

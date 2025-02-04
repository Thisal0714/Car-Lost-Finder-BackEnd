package CarFinder.dev.LostCarFinder.Controller;


import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Dto.ReqRes;
import CarFinder.dev.LostCarFinder.Dto.ResponseDto;
import CarFinder.dev.LostCarFinder.Entity.Car;
import CarFinder.dev.LostCarFinder.Entity.User;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/registerCar")
    public ResponseEntity<CarDto> registerCar(@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.registerCar(carDto));
    }

    @GetMapping("/get-carr/{ownerId}")

    public ResponseEntity<CarDto> getCarsByOwnerId(@PathVariable String ownerId) {
        CarDto carDto = carService.getCarsByOwnerId(ownerId);

        if (carDto.getStatusCode() == 200) {
            return ResponseEntity.ok(carDto);
        } else if (carDto.getStatusCode() == 404) {
            return ResponseEntity.status(404).body(carDto);
        } else {
            return ResponseEntity.status(500).body(carDto);
        }
    }

    @PutMapping("/update/{vehicleNumber}")
    public ResponseEntity<CarDto> updateCar(@PathVariable String vehicleNumber, @RequestBody Car carDto){
        return ResponseEntity.ok(carService.updateCar(vehicleNumber, carDto));
    }

}

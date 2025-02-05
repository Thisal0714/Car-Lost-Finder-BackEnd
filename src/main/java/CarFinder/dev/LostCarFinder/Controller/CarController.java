package CarFinder.dev.LostCarFinder.Controller;

import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Dto.StatusUpdateDto;
import CarFinder.dev.LostCarFinder.Lists.Status;
import CarFinder.dev.LostCarFinder.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get-car/{ownerId}")
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

    @PutMapping("/update-status/{carId}")
    public ResponseEntity<CarDto> updateCarStatus(@PathVariable String carId, @RequestBody StatusUpdateDto statusUpdateDto) {
        try {
            // Convert String status to Enum
            Status newStatus = Status.valueOf(statusUpdateDto.getStatus().toUpperCase());

            // Call the service to update the status
            CarDto response = carService.updateCarStatus(carId, newStatus, statusUpdateDto.getNewLocation());

            // Return the updated response
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (IllegalArgumentException e) {
            CarDto errorResponse = new CarDto();
            errorResponse.setStatusCode(400);
            errorResponse.setMessage("Invalid status value. Allowed values: ACTIVE, LOST, FOUND.");
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (Exception e) {
            CarDto errorResponse = new CarDto();
            errorResponse.setStatusCode(500);
            errorResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
    @GetMapping("/lostCars")
    public ResponseEntity<CarDto> searchCarByStatus(String status) {
        status="LOST";
        CarDto carDto = carService.searchCarByStatus(status);

        if (carDto.getStatusCode() == 200) {
            return ResponseEntity.ok(carDto);
        } else if (carDto.getStatusCode() == 404) {
            return ResponseEntity.status(404).body(carDto);
        } else {
            return ResponseEntity.status(500).body(carDto);
        }
    }

}

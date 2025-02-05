package CarFinder.dev.LostCarFinder.Controller;


import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Dto.GarageDto;
import CarFinder.dev.LostCarFinder.Dto.ResponseDto;

import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class GarageController {
    @Autowired
    private GarageService garageService;




    @PostMapping(value = "/registerGarage")
    public ResponseEntity<GarageDto> registerGarage(@RequestBody GarageDto garageDto){
        return ResponseEntity.ok(garageService.registerGarage(garageDto));
    }

    @GetMapping("/get-garage/{ownerId}")
    public ResponseEntity<GarageDto> getGaragesByOwnerId(@PathVariable String ownerId) {
        GarageDto garageDto = garageService.getGaragesByOwnerId(ownerId);

        if (garageDto.getStatusCode() == 200) {
            return ResponseEntity.ok(garageDto);
        } else if (garageDto.getStatusCode() == 404) {
            return ResponseEntity.status(404).body(garageDto);
        } else {
            return ResponseEntity.status(500).body(garageDto);
        }
    }

    @GetMapping("/garagesNear/{garageHome}")
    public ResponseEntity<GarageDto> getGaragesByCity(@PathVariable String garageHome) {
        GarageDto garageDto = garageService.getGaragesByCity(garageHome);

        if (garageDto.getStatusCode() == 200) {
            return ResponseEntity.ok(garageDto);
        } else if (garageDto.getStatusCode() == 404) {
            return ResponseEntity.status(404).body(garageDto);
        } else {
            return ResponseEntity.status(500).body(garageDto);
        }
    }

}

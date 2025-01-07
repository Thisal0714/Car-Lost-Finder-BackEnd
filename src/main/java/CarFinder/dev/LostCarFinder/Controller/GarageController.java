package CarFinder.dev.LostCarFinder.Controller;


import CarFinder.dev.LostCarFinder.Dto.GarageDto;
import CarFinder.dev.LostCarFinder.Dto.ResponseDto;
import CarFinder.dev.LostCarFinder.Dto.UserDto;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/garages")
public class GarageController {
    @Autowired
    private GarageService garageService;

    @Autowired
    private ResponseDto responseDto;

    //Adding a Garage

    @PostMapping(value = "/registerGarage")
    public ResponseEntity registerGarage(@RequestBody GarageDto garageDto){

        try{
            String res=garageService.registerGarage(garageDto);
            if(res.equals("00")){

                responseDto.setCode(Lists.RSP_SUCCESS);
                responseDto.setMessage("Success");
                responseDto.setContent(garageDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){

                responseDto.setCode(Lists.RSP_DUPLICATED);
                responseDto.setMessage("Already Registered");
                responseDto.setContent(garageDto);
                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);

            }else{

                responseDto.setCode(Lists.RSP_FAIL);
                responseDto.setMessage("Failed");
                responseDto.setContent(null);
                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception ex){
            responseDto.setCode(Lists.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(ex);
            return new ResponseEntity(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package CarFinder.dev.LostCarFinder.Controller;


import CarFinder.dev.LostCarFinder.Dto.ResponseDto;
import CarFinder.dev.LostCarFinder.Dto.UserDto;
import CarFinder.dev.LostCarFinder.Entity.User;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Repositories.UserRepository;
import CarFinder.dev.LostCarFinder.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseDto responseDto;


    // User registration

    @PostMapping(value = "/registerUser")
    public ResponseEntity registerUser(@RequestBody UserDto userDto){

        try{
            String res=userService.registerUser(userDto);
            if(res.equals("00")){

                responseDto.setCode(Lists.RSP_SUCCESS);
                responseDto.setMessage("Success");
                responseDto.setContent(userDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){

                responseDto.setCode(Lists.RSP_DUPLICATED);
                responseDto.setMessage("Already Registered");
                responseDto.setContent(userDto);
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


    // Update user details


    @PutMapping(value = "/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDto userDto){

        try{
            String res=userService.updateUser(userDto);
            if(res.equals("00")){

                responseDto.setCode(Lists.RSP_SUCCESS);
                responseDto.setMessage("Success");
                responseDto.setContent(userDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){

                responseDto.setCode(Lists.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not a Registered User.");
                responseDto.setContent(userDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

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

    // Get All Users -Admin Task

    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers(){
        try{
            List<UserDto> userDtoList=userService.getAllUsers();
            responseDto.setCode(Lists.RSP_SUCCESS);
            responseDto.setMessage("Success");
            responseDto.setContent(userDtoList);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);


        } catch (Exception ex) {
            responseDto.setCode(Lists.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(ex);
            return new ResponseEntity(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Search a user

    @GetMapping("/searchUser/{userId}")

    public ResponseEntity searchUser(@PathVariable String userId){
        try{
            UserDto userDto= userService.searchUser(userId);
            if(userDto!=null){responseDto.setCode(Lists.RSP_SUCCESS);
                responseDto.setMessage("Success");
                responseDto.setContent(userDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

            }else {

                responseDto.setCode(Lists.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No User for this User Id.");
                responseDto.setContent(null);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

            }
        }catch (Exception ex){
            responseDto.setCode(Lists.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(ex);
            return new ResponseEntity(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

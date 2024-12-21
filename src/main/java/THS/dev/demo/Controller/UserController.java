package THS.dev.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THS.dev.demo.Dto.ResponseDto;
import THS.dev.demo.Dto.UserDto;
import THS.dev.demo.Services.UserService;
import THS.dev.demo.Util.Lists;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private ResponseDto responseDto;
           
    @PostMapping(value = "/registerUser")

            public ResponseEntity registerUser(@RequestBody UserDto userDto){
                try{
                        String res=userService.registerUser(userDto);
                        if(res.equals("00")){
                                responseDto.setCode(Lists.RSP_SUCCESS);
                                responseDto.setMessage("Sucess");
                                responseDto.setContent(userDto);
                                return new ResponseEntity(responseDto,HttpStatus.ACCEPTED);
                        }else if(res.equals("06")){
                            responseDto.setCode(Lists.RSP_DUPLICATED);
                                responseDto.setMessage("Already Registered");
                                responseDto.setContent(userDto);
                                return new ResponseEntity(responseDto,HttpStatus.BAD_REQUEST);
                        }else{
                            responseDto.setCode(Lists.RSP_FAIL);
                                responseDto.setMessage("Error");
                                responseDto.setContent(null);
                                return new ResponseEntity(responseDto,HttpStatus.BAD_REQUEST); 
                        }
                }catch(Exception ex){
                    responseDto.setCode(Lists.RSP_ERROR);
                    responseDto.setMessage(ex.getMessage()); 
                    responseDto.setContent(null);
                    return new ResponseEntity(responseDto,HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }


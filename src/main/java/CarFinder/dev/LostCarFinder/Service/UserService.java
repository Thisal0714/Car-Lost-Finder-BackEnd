package CarFinder.dev.LostCarFinder.Service;

import CarFinder.dev.LostCarFinder.Dto.UserDto;
import CarFinder.dev.LostCarFinder.Entity.User;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;



    // User Registration

    public String registerUser(UserDto userDto) {

        if(userRepository.existsById(userDto.getUserId())){
            return Lists.RSP_DUPLICATED;
        }
        else{
            userRepository.save(modelMapper.map(userDto,User.class));
            return Lists.RSP_SUCCESS;
        }

    }

    // Update user details

    public String updateUser(UserDto userDto){

        if(userRepository.existsById(userDto.getUserId())){
            userRepository.save(modelMapper.map(userDto,User.class));
            return Lists.RSP_SUCCESS;
        }else{
            return Lists.RSP_NO_DATA_FOUND;
        }
    }

    // Get All users

    public List<UserDto> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList,new TypeToken<ArrayList<UserDto>>(){
        }.getType());
    }


    // Search a user

    public UserDto searchUser(String userId){
        if (userRepository.existsById(userId)){
            User user=userRepository.findById(userId).orElse(null);
            return modelMapper.map(user,UserDto.class);
        }else{
            return null;
        }
    }
}

package THS.dev.demo.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import THS.dev.demo.Dto.UserDto;
import THS.dev.demo.Repositories.UserRepository;
import THS.dev.demo.Util.Lists;
import THS.dev.demo.entity.Users;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String registerUser(UserDto userDto){
        if (userRepository.existsById(userDto.getUserId())) {
            return Lists.RSP_DUPLICATED;
        }else{
            userRepository.save(modelMapper.map(userDto, Users.class));
            return Lists.RSP_SUCCESS;
        }
    }
    
}

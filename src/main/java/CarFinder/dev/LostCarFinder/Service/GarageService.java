package CarFinder.dev.LostCarFinder.Service;


import CarFinder.dev.LostCarFinder.Dto.GarageDto;
import CarFinder.dev.LostCarFinder.Dto.UserDto;
import CarFinder.dev.LostCarFinder.Entity.Garage;
import CarFinder.dev.LostCarFinder.Entity.User;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Repositories.GarageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GarageService {


    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String registerGarage(GarageDto garageDto) {

        if(garageRepository.existsById(garageDto.getOwnerId())){
            return Lists.RSP_DUPLICATED;
        }
        else{
            garageRepository.save(modelMapper.map(garageDto, Garage.class));
            return Lists.RSP_SUCCESS;
        }

    }
}

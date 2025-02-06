package CarFinder.dev.LostCarFinder.Service;


import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Dto.GarageDto;

import CarFinder.dev.LostCarFinder.Entity.Car;
import CarFinder.dev.LostCarFinder.Entity.Garage;
import CarFinder.dev.LostCarFinder.Entity.User;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Lists.Status;
import CarFinder.dev.LostCarFinder.Repositories.GarageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class GarageService {


    @Autowired
    private GarageRepository garageRepository;



    public GarageDto registerGarage(GarageDto registrationRequest) {
        GarageDto resp = new GarageDto();
        try {
            Garage ourGarage = new Garage();
            ourGarage.setOwnerId(registrationRequest.getOwnerId());
            ourGarage.setGarageAddress(registrationRequest.getGarageAddress());
            ourGarage.setGarageHome(registrationRequest.getGarageHome());
            ourGarage.setGarageName(registrationRequest.getGarageName());
            ourGarage.setGarageSpecialization(registrationRequest.getGarageSpecialization());
            ourGarage.setGarageHotline(registrationRequest.getGarageHotline());

            Garage ourGarageResult = garageRepository.save(ourGarage);

            resp.setGarage(ourGarageResult);
            resp.setMessage("Garage Saved Successfully");
            resp.setStatusCode(200);

        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
    public GarageDto getGaragesByOwnerId(String ownerId) {
        GarageDto garageDto = new GarageDto();
        try {
            List<Garage> garages = garageRepository.findByOwnerId(ownerId);

            if (garages.isEmpty()) {
                throw new NoSuchElementException("No garages found for owner with ID '" + ownerId + "'");
            }

            garageDto.setGarages(garages);
            garageDto.setStatusCode(200);
            garageDto.setMessage("Cars for owner ID '" + ownerId + "' found successfully");

        } catch (NoSuchElementException e) {
            garageDto.setStatusCode(404);
            garageDto.setError("Not Found");
            garageDto.setMessage(e.getMessage());

        } catch (Exception e) {
            garageDto.setStatusCode(500);
            garageDto.setError("Internal Server Error");
            garageDto.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        System.out.println(garageDto);
        return garageDto;
    }


        public GarageDto getGaragesByCity(String garageHome) {
            GarageDto garageDto = new GarageDto();
            try {
                List<Garage> garage = garageRepository.findByGarageHome(garageHome);

                if (garage.isEmpty()) {
                    throw new NoSuchElementException("No garages found for city '" + garageHome + "'");
                }

                garageDto.setGarages(garage);
                garageDto.setStatusCode(200);
                garageDto.setMessage("Garages for city '" + garageHome + "' found successfully");

            } catch (NoSuchElementException e) {
                garageDto.setStatusCode(404);
                garageDto.setError("Not Found");
                garageDto.setMessage(e.getMessage());

            } catch (Exception e) {
                garageDto.setStatusCode(500);
                garageDto.setError("Internal Server Error");
                garageDto.setMessage("An unexpected error occurred: " + e.getMessage());
            }
            System.out.println(garageDto);
            return garageDto;
        }
    }



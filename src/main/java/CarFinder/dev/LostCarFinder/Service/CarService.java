package CarFinder.dev.LostCarFinder.Service;


import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Dto.ReqRes;
import CarFinder.dev.LostCarFinder.Entity.Car;
import CarFinder.dev.LostCarFinder.Entity.User;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class CarService {

    @Autowired
    private CarRepository carRepository;


    public CarDto registerCar(CarDto registrationRequest){
        CarDto resp = new CarDto();
        try{
            // Create a new Car entity from the CarDto request
            Car ourCar = new Car();
            ourCar.setOwnerId(registrationRequest.getOwnerId());
            ourCar.setOwnerName(registrationRequest.getOwnerName());
            ourCar.setBrand(registrationRequest.getBrand());
            ourCar.setModel(registrationRequest.getModel());
            ourCar.setProducedYear(registrationRequest.getProducedYear());
            ourCar.setRegisteredYear(registrationRequest.getRegisteredYear());
            ourCar.setTransmission(registrationRequest.getTransmission());

            // Save the car entity to the repository
            Car ourCarResult = carRepository.save(ourCar);

            // Manually map the fields to the CarDto response
            resp.setCar(ourCarResult);


            // Set the success message and status code
            resp.setMessage("Car Saved Successfully");
            resp.setStatusCode(200);

        } catch (Exception e) {
            // Handle any errors by setting the error details in the response
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }


    public CarDto getCarsByOwnerId(String ownerId) {
        CarDto carDto = new CarDto();
        try {
            List<Car> cars = carRepository.findByOwnerId(ownerId);

            if (cars.isEmpty()) {
                throw new NoSuchElementException("No cars found for owner with ID '" + ownerId + "'");
            }

            carDto.setCars(cars);
            carDto.setStatusCode(200);
            carDto.setMessage("Cars for owner ID '" + ownerId + "' found successfully");

        } catch (NoSuchElementException e) {
            carDto.setStatusCode(404);
            carDto.setError("Not Found");
            carDto.setMessage(e.getMessage());

        } catch (Exception e) {
            carDto.setStatusCode(500);
            carDto.setError("Internal Server Error");
            carDto.setMessage("An unexpected error occurred: " + e.getMessage());
        }

        return carDto;
    }

}

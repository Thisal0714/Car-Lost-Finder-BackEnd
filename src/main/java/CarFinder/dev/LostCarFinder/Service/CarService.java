package CarFinder.dev.LostCarFinder.Service;


import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Entity.Car;
import CarFinder.dev.LostCarFinder.Lists.Lists;
import CarFinder.dev.LostCarFinder.Repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            resp.setOwnerId(ourCarResult.getOwnerId());
            resp.setOwnerName(ourCarResult.getOwnerName());
            resp.setBrand(ourCarResult.getBrand());
            resp.setModel(ourCarResult.getModel());
            resp.setProducedYear(ourCarResult.getProducedYear());
            resp.setRegisteredYear(ourCarResult.getRegisteredYear());
            resp.setTransmission(ourCarResult.getTransmission());

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

}

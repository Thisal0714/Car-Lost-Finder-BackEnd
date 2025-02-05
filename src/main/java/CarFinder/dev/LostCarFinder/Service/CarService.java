package CarFinder.dev.LostCarFinder.Service;

import CarFinder.dev.LostCarFinder.Dto.CarDto;
import CarFinder.dev.LostCarFinder.Entity.Car;
import CarFinder.dev.LostCarFinder.Lists.Status;
import CarFinder.dev.LostCarFinder.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarDto registerCar(CarDto registrationRequest) {
        CarDto resp = new CarDto();
        try {
            Car ourCar = new Car();
            ourCar.setOwnerId(registrationRequest.getOwnerId());
            ourCar.setOwnerName(registrationRequest.getOwnerName());
            ourCar.setBrand(registrationRequest.getBrand());
            ourCar.setModel(registrationRequest.getModel());
            ourCar.setProducedYear(registrationRequest.getProducedYear());
            ourCar.setRegisteredYear(registrationRequest.getRegisteredYear());
            ourCar.setTransmission(registrationRequest.getTransmission());
            ourCar.setVehicleNumber(registrationRequest.getVehicleNumber());

            ourCar.setStatus(Optional.ofNullable(registrationRequest.getStatus())
                    .map(Status::valueOf)
                    .orElse(Status.ACTIVE));


            // Save the car entity to the repository
            Car ourCarResult = carRepository.save(ourCar);


            resp.setCar(ourCarResult);
            resp.setMessage("Car Saved Successfully");
            resp.setStatusCode(200);

        } catch (Exception e) {
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
        System.out.println(carDto);
        return carDto;
    }


    @Transactional
    public CarDto updateCarStatus(String carId, Status newStatus) {
        CarDto carDto = new CarDto();
        try {
            // Log the incoming carId
            System.out.println("Attempting to update car with ID: " + carId);

            // Find the car by ID
            Optional<Car> optionalCar = carRepository.findById(carId);

            if (optionalCar.isPresent()) {
                Car car = optionalCar.get();

                // Log current status before update
                System.out.println("Current status of car: " + car.getStatus());

                // Update the car's status
                car.setStatus(newStatus);

                // Save the updated car entity
                Car updatedCar = carRepository.save(car);  // This will save the existing car record with the updated status

                // Log updated status
                System.out.println("Updated status of car: " + updatedCar.getStatus());

                // Return the updated car in the response
                carDto.setCar(updatedCar);
                carDto.setStatusCode(200);
                carDto.setMessage("Car status updated successfully");
            } else {
                // If the car isn't found, log this and send a 404 response
                carDto.setStatusCode(404);
                carDto.setError("Not Found");
                carDto.setMessage("Car with ID '" + carId + "' not found");
                System.out.println("Car with ID '" + carId + "' not found in the database.");
            }
        } catch (Exception e) {
            carDto.setStatusCode(500);
            carDto.setError("Internal Server Error");
            carDto.setMessage("Error updating car status: " + e.getMessage());
            System.out.println("Error occurred while updating car status: " + e.getMessage());
        }
        return carDto;
    }


}

package CarFinder.dev.LostCarFinder.Entity;

import CarFinder.dev.LostCarFinder.Lists.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Cars")
public class Car {

    @Id
    private String id;

    private String ownerId;
    private String ownerName;
    private String brand;
    private String model;
    private String producedYear;
    private String transmission;
    private String registeredYear;
    private String vehicleNumber;
    private String stolenLocation;
    private LocalDateTime stolenTimeStamp;

    public LocalDateTime getStolenTimeStamp() {
        return stolenTimeStamp;
    }

    public void setStolenTimeStamp(LocalDateTime stolenTimeStamp) {
        this.stolenTimeStamp = stolenTimeStamp;
    }

    private Status status = Status.ACTIVE;


    public String getStolenLocation() {
        return stolenLocation;
    }

    public void setStolenLocation(String stolenLocation) {
        this.stolenLocation = stolenLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownername) {
        this.ownerName = ownername;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducedYear() {
        return this.producedYear;
    }

    public void setProducedYear(String producedYear) {
        this.producedYear = producedYear;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getRegisteredYear() {
        return this.registeredYear;
    }

    public void setRegisteredYear(String registeredYear) {
        this.registeredYear = registeredYear;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", producedYear='" + producedYear + '\'' +
                ", transmission='" + transmission + '\'' +
                ", registeredYear='" + registeredYear + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

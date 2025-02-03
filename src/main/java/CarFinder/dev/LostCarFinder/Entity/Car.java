package CarFinder.dev.LostCarFinder.Entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data

@Document(collection = "Cars")
public class Car {


    private String ownerId;
    private String ownerName;
    private String brand;
    private String model;
    private String producedYear;
    private String transmission;
    private String registeredYear;


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

    @Override
    public String toString() {
        return "Car{" +
                "ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", producedYear='" + producedYear + '\'' +
                ", transmission='" + transmission + '\'' +
                ", registeredYear='" + registeredYear + '\'' +
                '}';
    }
}

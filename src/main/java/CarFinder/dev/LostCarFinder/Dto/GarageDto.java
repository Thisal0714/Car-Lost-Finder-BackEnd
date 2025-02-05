package CarFinder.dev.LostCarFinder.Dto;


import CarFinder.dev.LostCarFinder.Entity.Car;
import CarFinder.dev.LostCarFinder.Entity.Garage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GarageDto {


    private int statusCode;
    private String message;
    private String error;
    private String ownerId;
    private String garageName;
    private String garageAddress;
    private String garageHome;
    private String garageSpecialization;
    private List<Garage> garages;
    private Garage garage;


    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public List<Garage> setGarages() { return garages; }


    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getGarageAddress() {
        return garageAddress;
    }

    public void setGarageAddress(String garageAddress) {
        this.garageAddress = garageAddress;
    }

    public String getGarageHome() {
        return garageHome;
    }

    public void setGarageHome(String garageHome) {
        this.garageHome = garageHome;
    }

    public String getGarageSpecialization() {
        return garageSpecialization;
    }

    public void setGarageSpecialization(String garageSpecialization) {
        this.garageSpecialization = garageSpecialization;
    }
}

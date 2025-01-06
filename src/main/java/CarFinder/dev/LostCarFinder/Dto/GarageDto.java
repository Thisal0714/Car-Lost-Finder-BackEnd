package CarFinder.dev.LostCarFinder.Dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class GarageDto {

    private String ownerId;
    private String garageName;
    private String garageAddress;
    private String garageHome;
    private String garageSpecialization;

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

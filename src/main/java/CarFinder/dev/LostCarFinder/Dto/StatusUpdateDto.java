package CarFinder.dev.LostCarFinder.Dto;

public class StatusUpdateDto {
    private String status;

    private String newLocation;

    public String getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

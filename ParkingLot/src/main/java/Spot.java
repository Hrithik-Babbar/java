import lombok.Getter;
import lombok.Setter;

@Getter
public class Spot {
    private int spotNumber;
    private VehicleType type;
    @Setter
    private Boolean isOccupied;
    public Spot(int spotNumber, VehicleType type){
        this.spotNumber = spotNumber;
        this.type = type;
        this.isOccupied = false;
    }
}

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

public class Floor {
    @Getter
    private int floorNumber;
    private List<Spot> spots;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<Spot>();
    }
    public void addSpot(VehicleType type){
        int lastSpot = spots.size();
        Spot spot = new Spot(lastSpot + 1, type);
        spots.add(spot);
    }
    public int findSpace(VehicleType vehicleType){
        for(Spot spot : spots){
            if(spot.getType() == vehicleType && !spot.getIsOccupied()){
                return spot.getSpotNumber();
            }
        }
        return -1;
    }
    public void parkVehicle(int spotNumber){
        for(Spot spot : spots){
            if(spot.getSpotNumber() == spotNumber){
                spot.setIsOccupied(true);
            }
        }
    }
}

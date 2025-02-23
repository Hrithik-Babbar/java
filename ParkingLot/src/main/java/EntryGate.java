import java.util.ArrayList;
import java.util.List;

public class EntryGate {
    private List<Floor> floors;
    public EntryGate() {
        this.floors = new ArrayList<Floor>();
    }
    public void addFloor(Floor floor){
        this.floors.add(floor);
    }
    public Ticket getTicket(Vehicle vehicle) {
        for(Floor floor : floors){
           int spotNumber = floor.findSpace(vehicle.getType());
           if(spotNumber != -1){
               floor.parkVehicle(spotNumber);
               return new Ticket(vehicle, spotNumber, floor.getFloorNumber());
           }
        }
        return null;
    }
}

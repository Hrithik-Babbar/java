import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class EntryGate {
    private final ReentrantLock lock = new ReentrantLock();
    private List<Floor> floors;
    public EntryGate() {
        this.floors = new ArrayList<Floor>();
    }
    public void addFloor(Floor floor){
        this.floors.add(floor);
    }
    public Ticket getTicket(Vehicle vehicle) {
        try{
            lock.tryLock(2, TimeUnit.SECONDS);
            for(Floor floor : floors){
                int spotNumber = floor.findSpace(vehicle.getType());
                if(spotNumber != -1){
                    Thread.sleep(1000);
                    floor.parkVehicle(spotNumber);
                    lock.unlock();
                    return new Ticket(vehicle, spotNumber, floor.getFloorNumber());
                }
            }
            return null;
        } catch (Exception e) {
            // do nothing.
        } finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}

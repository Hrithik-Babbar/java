import lombok.Getter;

import java.util.Date;
import java.util.Random;

public class Ticket {
    @Getter
    private int ticketNumber;
    private Vehicle vehicle;
    private int spotNumber;
    private int floorNumber;
    private Date start;
    public Ticket(Vehicle vehicle,int spotNumber, int floorNumber){
        this.vehicle = vehicle;
        this.start = new Date();
        this.spotNumber = spotNumber;
        this.floorNumber = floorNumber;
        this.ticketNumber = (new Random()).nextInt(10000);
    }
}

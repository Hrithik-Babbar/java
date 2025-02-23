import lombok.Getter;

@Getter
public class Vehicle {
    VehicleType type;
    String vehicleNumber;
    public Vehicle(VehicleType type, String vehicleNumber){
        this.type = type;
        this.vehicleNumber = vehicleNumber;
    }
}

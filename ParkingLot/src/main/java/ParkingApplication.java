public class ParkingApplication {
    public static void main(String[] args) {

        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();
        Floor floor = new Floor(1);

        floor.addSpot(VehicleType.Car);
        entryGate.addFloor(floor);

        Vehicle myCar = new Vehicle(VehicleType.Car,"ABC123");
        Ticket myTicket = entryGate.getTicket(myCar);
        Bill myBill = exitGate.getBill(myTicket);
        exitGate.makePayment(myBill);
    }
}

class sentry {
    private static int currentTicketId = 0;
}
public class ParkingApplication {
    public static void main(String[] args) {

        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();
        Floor floor = new Floor(1);

        floor.addSpot(VehicleType.Car);
        entryGate.addFloor(floor);

        Runnable t1 = () -> {
            Vehicle myCar = new Vehicle(VehicleType.Car,"ABC123");
            Ticket myTicket = entryGate.getTicket(myCar);
            if(myTicket != null){
                System.out.println(myTicket.getTicketNumber());
            }
            Bill myBill = exitGate.getBill(myTicket);
            exitGate.makePayment(myBill);
        };
        Runnable t2 = () -> {
            Vehicle myCar = new Vehicle(VehicleType.Car,"ABC125");
            Ticket myTicket = entryGate.getTicket(myCar);
            if(myTicket != null){
                System.out.println(myTicket.getTicketNumber());
            }
            Bill myBill = exitGate.getBill(myTicket);
            exitGate.makePayment(myBill);
        };
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}

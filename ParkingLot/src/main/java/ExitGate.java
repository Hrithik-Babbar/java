public class ExitGate {
    public BillGenerationStrategy strategy;

    public ExitGate() {
        this.strategy = new HourlyBillGenrationStrategy();
    }
    public Bill getBill(Ticket ticket) {
        int amountToBePaid = strategy.getAmount(ticket);
        return new Bill(amountToBePaid, ticket);
    }
    public void makePayment(Bill bill){
        Payment payment = bill.getPayment();
        payment.setPaymentStatus(true);
    }
}

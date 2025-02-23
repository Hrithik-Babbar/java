import lombok.Getter;

public class Bill {
    private int amount;
    private Ticket ticket;
    @Getter
    private Payment payment;
    public Bill(int amount, Ticket ticket) {
        this.amount = amount;
        this.ticket = ticket;
        this.payment = new Payment();
    }
}

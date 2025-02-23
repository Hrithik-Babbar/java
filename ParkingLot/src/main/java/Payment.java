import lombok.Setter;

import java.util.UUID;

public class Payment {
    private String paymentId;
    @Setter
    private Boolean paymentStatus;
    public Payment(){
        paymentId = UUID.randomUUID().toString();
        paymentStatus = false;
    }
}

package accommodation;

public class PaymentCompleted extends AbstractEvent {

    public PaymentCompleted(){
        super();
    }

    private int reservationNumber;
    private int paymentId;
    private int paymentPrice;
    private String paymentStatus;
    private String reservationStatus;

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(int paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

}


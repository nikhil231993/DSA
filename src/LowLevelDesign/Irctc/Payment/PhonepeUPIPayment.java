package LowLevelDesign.Irctc.Payment;

public class PhonepeUPIPayment extends UPIPayment {

    @Override
    public void ProcessUPIPayment(double amount) {
        System.out.println("Using Phonepe UPI Payment");
    }
}

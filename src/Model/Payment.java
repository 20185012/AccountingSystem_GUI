package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable {
    //int paymentId;
    Money paymentSum;
    LocalDate paymentDate;
    //String paymentDescription;
    //String paymentBeneficiary;
    //String paymentBeneficiaryNumber;


    public Payment(Money amount) {
        this.paymentSum = amount;
        this.paymentDate = LocalDate.now();
    }

    public static Payment MakeNewPayment(Money amount)
    {
        return new Payment(amount);
    }

    public void ShowPaymentDetails()
    {
        System.out.println("Sum: " + this.paymentSum.getAmount() + "  Transaction Date: " + this.paymentDate);
    }

    public Money getPaymentSum() {
        return paymentSum;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}

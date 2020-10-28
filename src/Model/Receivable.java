package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Receivable implements Serializable {
    Money receivableSum;
    LocalDate receivableDate;
    //String receivableDescription;
    //String remitterName;
    //String remitterAccountNumber;


    public Receivable(Money amount) {
        this.receivableSum = amount;
        this.receivableDate = LocalDate.now();
    }

    public static Receivable MakeNewReceivable (Money amount)
    {
        return new Receivable(amount);
    }


    public void ShowReceivableDetails()
    {
        System.out.println("Sum: " + this.receivableSum.getAmount() + " Transaction date: " + this.receivableDate);
    }
}

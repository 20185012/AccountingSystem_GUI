package Model;


import java.io.Serializable;
import java.util.Scanner;

public class Money implements Serializable {
    private float amount;



    public Money(Float amount) {
        this.amount = SetMonetaryPrecision(amount);
    }

    public Money() {
        this.amount = (float) 0;
    }

    public float getAmount() {
        return SetMonetaryPrecision(amount);
    }



    public static float ConvertToMoney(String text)
    {
        return MakeMonetaryFormat(text);
    }

    private static float MakeMonetaryFormat(String text) {
        try {

            float amount = Float.parseFloat(text);
            amount = SetMonetaryPrecision(amount);
            return amount;

        } catch (NumberFormatException e) {
            System.out.println("What you entered is not a valid number. Try again.");
            return SpecifyPrice();
        }

    }

    private static float SetMonetaryPrecision(float floatNumber) {
        float multiplier = (float) Math.pow(10,2);
        floatNumber = (Math.round(floatNumber * multiplier) / multiplier);
        return floatNumber;
    }

    public static float SpecifyPrice()
    {
        Scanner scanner = new Scanner(System.in);
        String price = scanner.next();
        return ConvertToMoney(price);
    }

    public void AddMoney(Money money)
    {
        this.amount += money.getAmount();
    }

    public void SubtractMoney(Money money)
    {
        this.amount -= money.getAmount();
    }
}

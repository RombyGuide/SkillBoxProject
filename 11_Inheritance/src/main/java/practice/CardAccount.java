package practice;

public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    private final double interest = 0.01;

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        if ((amountToTake > 0) && (amountToTake < balance)) {
            double sumAmountToTake = amountToTake * interest;
            amountToTake += sumAmountToTake;
            balance -= amountToTake;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package practice;

public class BankAccount {
  protected double balance;

  public double getAmount() {
    // верните значение количества денег не счету
    return balance;
  }

  public void put(double amountToPut) {
    // метод зачисляет деньги на счет
    if (amountToPut > 0) {
      balance =+ amountToPut;
    }
  }

  public void take(double amountToTake) {
    // метод списывает деньги со счета
    if ((amountToTake > 0) && (amountToTake < balance)) {
      balance -= amountToTake;
    }
  }

  @Override
  public String toString() {
    return "BankAccount{" +
            "balance=" + balance +
            '}';
  }
}

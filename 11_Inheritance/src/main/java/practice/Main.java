package practice;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new CardAccount();
        System.out.println(bankAccount);

        bankAccount.put(1500);
        System.out.println(bankAccount);

        bankAccount.take(100);
        System.out.println(bankAccount);
    }
}

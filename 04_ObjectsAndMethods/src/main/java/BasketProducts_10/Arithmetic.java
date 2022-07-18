package BasketProducts_10;

public class Arithmetic {
    private int arithmeticFirstNumber = 0;
    private int arithmeticSecondNumber = 0;

    public Arithmetic(int arithmeticFirstNumber, int arithmeticSecondNumber) {
        this.arithmeticFirstNumber = arithmeticFirstNumber;
        this.arithmeticSecondNumber = arithmeticSecondNumber;
    }

    public void sumNumbers() {
        int sum = arithmeticFirstNumber + arithmeticSecondNumber;
        print(sum);
    }

    public void multNumbers() {
        int mult = arithmeticFirstNumber * arithmeticSecondNumber;
        print(mult);
    }

    public void minNumbers() {
        if (arithmeticFirstNumber <= arithmeticSecondNumber) {
            print(arithmeticFirstNumber);
        } else {
            print(arithmeticSecondNumber);
        }
    }

    public void maxNumbers() {
        if (arithmeticFirstNumber >= arithmeticSecondNumber) {
            print(arithmeticFirstNumber);
        } else {
            print(arithmeticSecondNumber);
        }
    }

    public void print(int number) {
        System.out.println(number);
    }
}
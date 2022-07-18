package skillbox.Enum;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(5,5);
        arithmeticCalculator.calculate(EnumOperation.ADD);
    }
}

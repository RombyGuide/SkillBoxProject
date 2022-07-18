package skillbox.Enum;

public class ArithmeticCalculator {
    private int firstNumber;
    private int secondNumber;

    public ArithmeticCalculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void calculate(EnumOperation enumOperation) {
        switch (enumOperation) {
            case ADD -> System.out.println(firstNumber + secondNumber);
            case SUBTRACT -> System.out.println(firstNumber - secondNumber);
            case MULTIPLY -> System.out.println(firstNumber * secondNumber);
        }
    }
}

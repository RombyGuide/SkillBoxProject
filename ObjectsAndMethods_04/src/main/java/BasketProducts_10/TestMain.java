package BasketProducts_10;

public class TestMain {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(32,47);
        arithmetic.sumNumbers();
        arithmetic.multNumbers();
        arithmetic.minNumbers();
        arithmetic.maxNumbers();

        Printer printer = new Printer();
        printer.append("таблица с оценками", "Оценки 4А", 2);
        printer.append("история 17 века", "История", 3);
        printer.append("результаты эстофеты", "Эстафета");
        printer.append("надпись");
        System.out.println("Добавлены " + printer.getPendingPagesCount() + " страниц на печать!");
        printer.print();
        System.out.println("За всё время распечатанно " + printer.getPrintedPagesCount() + " страниц!");
    }
}

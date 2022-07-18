package skillbox.Elevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        System.out.println("Введите номер этажа: ");
        int floor = new Scanner(System.in).nextInt();
        elevator.move(floor);
        System.out.println("Мы приехали на " + elevator.getCurrentFloor() + " этаж");
    }
}

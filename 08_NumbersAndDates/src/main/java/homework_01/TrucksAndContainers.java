package homework_01;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя

        int boxes = scanner.nextInt();
        int container;
        int truck;

        if (boxes > 0) {
            container = boxes % 27 == 0 ? boxes / 27 : boxes / 27 + 1;
            truck = container % 12 == 0 ? container / 12 : container / 12 + 1;

            int b = 1;
            int c = 1;
            for (int i = 1; i <= truck; i++) {
                System.out.println("Грузовик: " + i);

                int j = 0;
                while (j < 12 && c <= container) {
                    System.out.println("\tКонтейнер: " + c);

                    int k = 0;
                    while (k < 27 && b <= boxes) {
                        System.out.println("\t\tЯщик: " + b);
                        k++;
                        b++;
                    }
                    j++;
                    c++;
                }
            }
            System.out.println("Необходимо:\nгрузовиков - " + truck + " шт." +
                    "\nконтейнеров - " + container + " шт.");
        } else {
            System.out.println("Необходимо:\nгрузовиков - " + 0 + " шт." +
                    "\nконтейнеров - " + 0 + " шт.");
        }

            // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
            // пример вывода при вводе 2
            // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}

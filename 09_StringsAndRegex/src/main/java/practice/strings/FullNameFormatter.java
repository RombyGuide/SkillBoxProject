package practice.strings;

import java.util.Scanner;

public class FullNameFormatter {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        scanner.close();
        break;
      }

      String name = input;
      int space = 0;
      for (int i = 0; i < name.length(); i++) {
        if (name.charAt(i) == ' ') {
          space++;   //считаем количество пробелов между словами, введенными в консоль
        }
      }

      for (int i = 0; i < name.length(); i++) {
        //условие, исключающее наличие цифр
        if (name.charAt(i) >= '0' && name.charAt(i) <= '9'
                // условие проверки количества пробелов,
                // слов должно быть 3, значит количество пробелов
                // - не больше 2 и не равно 0
                || space > 2 || space == 0)
        {
          System.out.println("Введенная строка не является ФИО");
          break;
        } else {
          System.out.println(
                  "Фамилия: " + name.substring(0, name.indexOf(' ')) + System.lineSeparator() +
                          "Имя:" + name.substring(name.indexOf(' '), name.lastIndexOf(' ')) + System.lineSeparator() +
                          "Отчество:" + name.substring(name.lastIndexOf(' ')));
          break;

        }
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }
}
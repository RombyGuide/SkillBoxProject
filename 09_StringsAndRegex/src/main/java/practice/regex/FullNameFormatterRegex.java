package practice.regex;

import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameFormatterRegex {

  public static void main(String[] args) {

    //TODO:напишите ваш код тут, результат вывести в консоль.
    //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        scanner.close();
        break;
      }

      String regex = "([а-яА-ЯеЁ\\-]+\\s+)([а-яА-ЯеЁ]+\\s+)([а-яА-ЯеЁ]+)$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      int count = 0;
      while (matcher.find()) {
        count += matcher.groupCount();
        String lastName = matcher.group(1).trim();
        String firstName = matcher.group(2).trim();
        String surName = matcher.group(3).trim();

        Formatter fullName = new Formatter();
        fullName.format("Фамилия: %s%nИмя: %s%nОтчество: %s", lastName, firstName, surName);
        System.out.println(fullName);
      }

      if (count != 3) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
    }
  }
}
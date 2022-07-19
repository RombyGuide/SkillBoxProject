package homework_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 5;
        int month = 2;
        int year = 2000;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);

        String text = "";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; birthday.isBefore(today) || birthday.equals(today); i++) {
            text = i + " - " + birthday.format(formatDate);
            stringBuilder.append(text);
            stringBuilder.append(System.lineSeparator());
            birthday = birthday.plusYears(1);
        }
        return stringBuilder.toString();

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
    }
}

package homework_02;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Periods {
    // реализуйте вывод разницы между датами, используя класс Period
    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        firstDate.parse("28.02.2000", formatter);
        secondDate.parse("16.05.2022", formatter);
        Period period = Period.between(firstDate, secondDate);
        return "years:" + period.getYears() + ", " +
                "months:" + period.getMonths() + ", " +
                "days:" + period.getDays();
    }
}

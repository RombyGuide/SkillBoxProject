package homework.StringExperiments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            sum += Integer.parseInt(text.substring(matcher.start(), matcher.end()));
        System.out.println("Общая сумма заработка всех: " + sum);
    }
}


package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private final TreeSet<String> emailList = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public void add(String email) {
        // валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        String regex = "([A-z0-9.-]+)@([A-Za-z]+)\\.([A-z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email.toLowerCase(Locale.ROOT));

        if (!matcher.matches()) {
            System.out.println(WRONG_EMAIL_ANSWER);
        } else if (emailList.contains(email)) {
            System.out.println("Данный email уже существует");
        } else {
            emailList.add(email);
            System.out.println("Добавлен email " + email);
        }
    }

    public List<String> getSortedEmails() {
        // возвращается сортированный список электронных адресов в алфавитном порядке
        return new ArrayList<>(emailList);
    }
}


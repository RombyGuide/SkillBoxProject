package practice.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitText {

  public static void main(String[] args) {
    String text = " ";

    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод
      String regex = "[’a-zA-Z]+";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(text);
      List<String> list = new ArrayList<>();
      while (matcher.find()) {
        list.add(matcher.group());
      }
      return list.stream().collect(Collectors.joining("\n"));
    }
  }


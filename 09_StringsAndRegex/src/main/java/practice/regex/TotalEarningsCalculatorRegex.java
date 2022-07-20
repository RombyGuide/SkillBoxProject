package practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalEarningsCalculatorRegex {

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    int sum = 0;
    Pattern p = Pattern.compile("\\b\\d+\\b");
    Matcher m = p.matcher(text);
    while (m.find()){
      sum+=Integer.parseInt(m.group());
    }
    System.out.println(sum);
    return sum;
  }
}
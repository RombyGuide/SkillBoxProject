package practice.strings;

public class TotalEarningsCalculator {

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль

    String charsetStr1 = "Вася заработал";
    int start = text.indexOf(charsetStr1) + charsetStr1.length();
    int end = text.indexOf("рублей", start);
    String str1 = text.substring(start, end).trim();
    int sum1 = Integer.parseInt(str1);

    String charsetStr2 = "Петя -";
    int start2 = text.indexOf(charsetStr2) + charsetStr2.length();
    int end2 = text.indexOf("рубля", start2);
    String str2 = text.substring(start2, end2).trim();
    int sum2 = Integer.parseInt(str2);

    String charsetStr3 = "Маша -";
    int start3 = text.indexOf(charsetStr3) + charsetStr3.length();
    int end3 = text.indexOf("рублей", start3);
    String str3 = text.substring(start3, end3).trim();
    int sum3 = Integer.parseInt(str3);

    int sum = sum1 + sum2 + sum3;

    System.out.println(sum);
  }
}
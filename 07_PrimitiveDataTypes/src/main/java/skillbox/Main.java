package skillbox;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount() + "\n");

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        for (int i = 0; i < 65536; i++) {
            char c = (char) i;
            if (c == 'Ё' || c == 'ё') {
                System.out.println(i + " - " + c);
            } else if (c >= 'А' && c <= 'я') {
                System.out.println(i + " - " + c);
            }
        }
    }
}

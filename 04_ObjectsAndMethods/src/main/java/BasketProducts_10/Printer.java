package BasketProducts_10;

public class Printer {
    String queue = "";
    int pendingPagesCount = 0;
    int printedPagesCount = 0;


    public void append(String textDoc) {
        append(textDoc, "Default");
    }

    public void append(String textDoc, String nameDoc) {
        append(textDoc, nameDoc, 1);
    }

    public void append(String textDoc, String nameDoc, int quantityPages){
        queue = queue + "Текст: " + textDoc + "\n" +
                "Название: " + nameDoc + "\n" + "Количество: " + quantityPages + "\n";
        pendingPagesCount = pendingPagesCount + quantityPages;
        printedPagesCount = printedPagesCount + quantityPages;
    }

    public void clear() {
        queue = "";
        pendingPagesCount = 0;
    }

    public void print() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            System.out.println(queue);
            System.out.println("Очередь печати очищенна");
        }

        clear();
    }

    public int getPendingPagesCount() {
        return pendingPagesCount;
    }

    public int getPrintedPagesCount() {
        return printedPagesCount;
    }
}

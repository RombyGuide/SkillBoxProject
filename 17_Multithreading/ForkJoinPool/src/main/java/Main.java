import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String URL = "https://metanit.com/";
    private static final int COUNT_DEFAULT_SLASH = URL.length() - URL.replace("/", "").length();

    public static void main(String[] args) {
        ReferenceParser referenceParser = new ReferenceParser(URL);

        System.out.println("Запись файла началась...");
        long startTime = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(referenceParser);
        referenceParser.getSortedSetLinks().stream()
                .map(Main::getStringWithTabs)
                .forEach(Main::writer);

        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (endTime - startTime) / 1000 + " сек.\nЗапись файла завершена.");
    }

    private static String getStringWithTabs(String line) {
        int countSlash = line.length() - line.replace("/", "").length();
        if (countSlash <= COUNT_DEFAULT_SLASH)
            return "".concat(line);

        return "\t".repeat(Math.max(0, countSlash - COUNT_DEFAULT_SLASH)).concat(line);
    }

    private static void writer(String line){
        try (FileWriter fileWriter = new FileWriter(
                "17_Multithreading/ForkJoinPool/src/main/resources/siteOfMap.txt", true)){
            fileWriter.write(line.concat("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserFile {
    public static void main(String[] args) {
        String htmlFile = parseFile("15_FilesAndNetwork/DataCollector/data/code.html");

        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("a.menu__link");
        elements.forEach(element -> System.out.println(element.text()));

        System.out.println(htmlFile);
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.forEach(line -> builder.append(line + "\n"));

        return builder.toString();
    }
}

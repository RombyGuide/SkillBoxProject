import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://skillbox-java.github.io/").get();
        doc.select("span[data-line]").
                forEach(a -> System.out.println(a.attr("data-line") + ". " + a.text()));

    }
}

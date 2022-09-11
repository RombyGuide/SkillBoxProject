import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveAction;

public class ReferenceParser extends RecursiveAction {
    private final String url;
    private static Set<String> links = new HashSet<>();

    public ReferenceParser(String url){
        this.url = url;
    }

    public Set<String> getSortedSetLinks() {
        return new TreeSet<>(links);
    }

    @Override
    protected void compute() {
        Set<ReferenceParser> setChildLinks = new HashSet<>();
        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a");
            for (Element element : elements) {
                String link = element.absUrl("href");
                if (!link.isEmpty() && link.startsWith(url) && !links.contains(link) && !link.contains("#")) {
                    links.add(link);
                    ReferenceParser referenceParser = new ReferenceParser(link);
                    referenceParser.fork();
                    setChildLinks.add(referenceParser);
                }
            }
        } catch (HttpStatusException ex) {
            System.out.println("Code status " + ex.getStatusCode() + " -> " + ex.getUrl());

        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }

        for (ReferenceParser element : setChildLinks) {
            element.join();
        }
    }
}
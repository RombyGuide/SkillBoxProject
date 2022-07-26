import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, NullPointerException {
        List<Post> posts = new ArrayList<>();
        Document doc = Jsoup.connect("https://4pda.to/").get();
        Elements products = doc.getElementsByAttributeValue("itemprop", "url");
        for (Element product : products) {
            String detailsLink = product.attr("href");
            Post post = new Post();
            post.setDetailsLink(detailsLink);
            post.setTitle(product.attr("title"));
            System.out.println("Подключение к деталям о посте: " + detailsLink);
            Document postDetailsDoc = Jsoup.connect(detailsLink).get();
            try {
                Element authorElement = postDetailsDoc.getElementsByClass("name").first().child(0);
                post.setAuthor(authorElement.text());
                post.setAuthorDetailsLink(authorElement.attr("href"));
                post.setDateOfCreated(postDetailsDoc.getElementsByClass("date").first().text());
                posts.add(post);
            } catch (NullPointerException ex) {
                post.setAuthor("Автора нет!");
                post.setAuthorDetailsLink("Ссылки нет!");
                post.setDateOfCreated("Даты создания нет!");
            }
        }
        posts.forEach(System.out::println);
    }
}

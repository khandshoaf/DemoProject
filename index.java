import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try {

            Document document = Jsoup.connect("https://cotich.net/").get();

            Elements storyElements = document.select("div[class=item]");


            for (Element element : storyElements) {
                // Trích xuất đường dẫn của hình ảnh
                String imageURL = element.select("a").attr("src");

                // Trích xuất tiêu đề của truyện
                String title = element.select("a").text();

                // Trích xuất đường dẫn của truyện
                String url = element.select("a").attr("abs:href");

                // Trích xuất nội dung của truyện
                String content = element.select("p").text();


                System.out.println("Hình ảnh: " + imageURL);
                System.out.println("Tiêu đề: " + title);
                System.out.println("Đường dẫn: " + url);
                System.out.println("Nội dung: " + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
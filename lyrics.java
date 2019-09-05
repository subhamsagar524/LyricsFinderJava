import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class lyrics {
	
	public static void main(String[] args) {
		
	String song, singer, url;
        Scanner sc = new Scanner(System.in);
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter the song name : ");
        song = sc.nextLine();
        System.out.println("Enter the singer name : ");
        singer = sr.nextLine();
        singer = singer.replaceAll(" ", "_");
        
        url = "http://lyrics.wikia.com/wiki/";
        url = url + singer;
        url = url + ':';
        url = url + song;
        
        Document doc = null;
        try {
           doc = Jsoup.connect(url).get(); // URL shortened!
        } catch (IOException ioe) {
           ioe.printStackTrace();
        }
        
        Elements text = doc.select("div[class=lyricbox]");
        url = text.toString();
        url = url.replaceAll("<br>", "");
        url = url.replaceAll("<b>", "");
        url = url.replaceAll("</b>", "");
        url = url.replaceAll("<div class=\"lyricbox\">", "");
        url = url.replaceAll("<div class=\"lyricsbreak\"></div>", "");
        url = url.replaceAll("</div>", "");
        
        System.out.println(url);
	}

}

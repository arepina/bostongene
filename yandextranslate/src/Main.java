import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    private static final String apiKey = "trnsl.1.1.20181028T091600Z.f400e3472e0db47a.3eead0f798d025c158ad45a46daa58c6f561e3aa";

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while(true) {
            System.out.println("Enter the phrase or press ! to stop");
            String phrase = sc.nextLine();
            if(!phrase.equals("!")) {
                try {
                    translate(phrase.replaceAll(" ", "+"));
                } catch (Exception e) {
                    System.out.println("There was an error during translation, try again");
                }
            }else
                break;
        }
    }

    private static void translate(String phrase) throws Exception {
        String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + apiKey + "&lang=en-ru&text=" + phrase;
        URLConnection connection = new URL(url).openConnection();
        String json = new java.util.Scanner(connection.getInputStream()).nextLine();
        String translated = json.substring(json.indexOf("[") + 2, json.indexOf("]") - 1);
        System.out.println(translated);
    }


}

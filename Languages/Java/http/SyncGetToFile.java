import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SyncGetToFile {

    public static void get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<Path> response = client.send(request, BodyHandlers.ofFile(Paths.get("body.txt")));

        System.out.println("Response in file: " + response.body());
    }

    public static void main(String[] args) {
        try {
            get("https://globo.com");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

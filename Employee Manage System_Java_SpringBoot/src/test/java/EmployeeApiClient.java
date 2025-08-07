import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EmployeeApiClient {

    private static final String BASE_URL = "http://localhost:8080/api/employees";
    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        // 1. ایجاد کارمند جدید (POST)
        String newEmployeeJson = """
            {
                "firstName": "hassan",
                "lastName": "dari",
                "email": "hasan.dari@example.com"
            }
            """;
        sendPost(newEmployeeJson);

        // 2. دریافت همه کارمندان (GET)
        sendGetAll();

        // 3. دریافت کارمند با id=1 (GET)
        sendGetById(1);

        // 4. بروزرسانی کارمند با id=1 (PUT)
        String updatedEmployeeJson = """
            {
                "firstName": "ali",
                "lastName": "mohammadi",
                "email": "ali.mohammadi@example.com"
            }
            """;
        sendPut(1, updatedEmployeeJson);

        // 5. حذف کارمند با id=1 (DELETE)
        sendDelete(1);
    }

    private static void sendPost(String json) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("POST Status code: " + response.statusCode());
        System.out.println("POST Response body: " + response.body());
        System.out.println("------------------------------------------------");
    }

    private static void sendGetAll() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET ALL Status code: " + response.statusCode());
        System.out.println("GET ALL Response body: " + response.body());
        System.out.println("------------------------------------------------");
    }

    private static void sendGetById(long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET BY ID Status code: " + response.statusCode());
        System.out.println("GET BY ID Response body: " + response.body());
        System.out.println("------------------------------------------------");
    }

    private static void sendPut(long id, String json) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("PUT Status code: " + response.statusCode());
        System.out.println("PUT Response body: " + response.body());
        System.out.println("------------------------------------------------");
    }

    private static void sendDelete(long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("DELETE Status code: " + response.statusCode());
        System.out.println("DELETE Response body: " + response.body());
        System.out.println("------------------------------------------------");
    }
}

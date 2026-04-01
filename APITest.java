import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = RestAssured.get("/users");

        System.out.println("Response Body: " + response.getBody().asString());

        if (response.getStatusCode() == 200) {
            System.out.println("Status Code Validation PASSED");
        } else {
            System.out.println("Status Code Validation FAILED");
        }
    }
}

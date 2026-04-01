import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BDDTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("[0].id", equalTo(1));

        System.out.println("BDD Test Passed");
    }
}

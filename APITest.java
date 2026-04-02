import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class APITest extends BaseTest {

    @Test
    public void getUsers() {

        Response response = given()
                .when()
                .get("/users");

        System.out.println(response.getBody().asString());

        if (response.getStatusCode() == 200) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}
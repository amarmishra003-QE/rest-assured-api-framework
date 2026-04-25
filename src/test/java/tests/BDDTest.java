package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BDDTest extends BaseTest {

    @Test
    public void bddCreateUserTest() {
        String payload = "{ \"name\": \"Amar\", \"job\": \"Automation QA\" }";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Amar"))
            .body("job", equalTo("Automation QA"));
    }
}

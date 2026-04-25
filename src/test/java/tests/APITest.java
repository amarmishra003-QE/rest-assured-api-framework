
package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest extends BaseTest {

    @Test
    public void getSingleUserTest() {
        given()
            .log().all()
        .when()
            .get("/users/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", containsString("@reqres.in"));
    }

    @Test
    public void createUserTest() {
        String payload = "{ \"name\": \"Amar\", \"job\": \"QA Engineer\" }";

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/users")
        .then()
            .log().all()
            .statusCode(201)
            .body("name", equalTo("Amar"))
            .body("job", equalTo("QA Engineer"));
    }

    @Test
    public void updateUserTest() {
        String payload = "{ \"name\": \"Amar\", \"job\": \"Senior QA Engineer\" }";

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .put("/users/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("job", equalTo("Senior QA Engineer"));
    }

    @Test
    public void deleteUserTest() {
        given()
            .log().all()
        .when()
            .delete("/users/2")
        .then()
            .log().all()
            .statusCode(204);
    }
}

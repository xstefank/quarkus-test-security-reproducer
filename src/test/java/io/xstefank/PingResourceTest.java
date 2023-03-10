package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PingResourceTest {

    // works as expected
    @Test
    @TestSecurity(user = "test", roles = "test")
    public void loggedUserWorking() {
        given()
            .when().get("/ping")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive test"));
    }

    @Test
    @TestSecurity
    public void seemsToWorkNow() {
        given()
            .when().get("/ping")
            .then()
            .statusCode(401);
    }

}
package xast.sbertasks.SberCRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(classes = SberCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SberCrudAppTestRestAssured {

    @BeforeAll
    public static void setUp(){
        RestAssured.port = 7070;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void whenGetUsers_thenReturnStatus200() {
        given().when()
                .get("/person")
                .then()
                .statusCode(200);
    }

    @Test
    public void whenGetUsers_thenReturnHTML() {
        given().when()
                .get("/person")
                .then()
                .contentType(ContentType.HTML);
    }

    @Test
    public void whenGetPersonById_thenReturnStatus200() {
        given().when()
                .get("/person/2")
                .then()
                .statusCode(200)
                .body("person.id", equalTo(2));
    }

    @Test
    public void whenDeletePerson_thenReturnStatusRedirect() {
        given().when()
                .delete("/person/2")
                .then()
                .statusCode(302);
    }

    @Test
    public void whenNewtUser_thenReturnHTML() {
        given().when()
                .get("/person/new")
                .then()
                .contentType(ContentType.HTML);
    }


}

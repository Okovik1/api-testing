package pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutPetPositiveTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void putPetPositiveTest() {
        File json = new File("src/test/resources/newPetPut");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(json)
                        .when()
                        .put("v2/pet");
        response.then().assertThat().statusCode(200).body("id", equalTo(543), "name", equalTo("Oscar"), "status", equalTo("pending"));
    }
}



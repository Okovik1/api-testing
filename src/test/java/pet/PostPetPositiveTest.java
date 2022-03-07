package pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostPetPositiveTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void postPetPositiveTest() {
        File json = new File("src/test/resources/newPet.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(json)
                        .when()
                        .post("v2/pet");
        response.then().assertThat().statusCode(200).body("id", equalTo(33));
    }
}


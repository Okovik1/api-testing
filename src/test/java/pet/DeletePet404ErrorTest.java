package pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletePet404ErrorTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void deletePet404ErrorTest() {
        Response response =
                given()
                        .delete("v2/pet/343");
        response.then().assertThat().statusCode(404);
    }
}


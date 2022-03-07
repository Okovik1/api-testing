package pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetPetFindByStatusPositiveTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void getPetFindByStatusPositiveTest() {
        Response response =
                given()
                        .get("v2/pet/findByStatus?status=pending");
        response.then().assertThat().statusCode(200);
    }
}


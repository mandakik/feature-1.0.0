package fakerAPITests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class get10Rows {

    //https://fakestoreapi.com/products?limit=10

    @BeforeTest
    public void setup(){
        RestAssured.baseURI="https://fakestoreapi.com";
    }

    @Test
    public void fetchFirst10Records(){
        Response response = given()
                .queryParam("limit",5)
                .when()
                .get("/products")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract().response();

        //response.prettyPrint();

        String title = response.jsonPath().getString("[1].title");
        System.out.println("Title is : "+title);

        String responseString = response.asString();


    }


}

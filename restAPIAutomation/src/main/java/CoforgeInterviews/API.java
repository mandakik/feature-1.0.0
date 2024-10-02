package CoforgeInterviews;
//http://gorest.co.in/public/v2/users
//https://gorest.co.in/public/v2/users?gender=female

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API {

    @Test
    public void test(){
        RestAssured.baseURI="//https://gorest.co.in";
       /* RequestSpecification requestSpecification= RestAssured.given()
                .pathParam("path","public/v2/users")
                .queryParam("gender","female");
        Response res= requestSpecification.get();
        System.out.println(res.prettyPrint());*/

        Response res1;

        res1=given()

                .queryParam("gender","female")
                .when()
                .get("/public/v2/users");

        System.out.println(res1.toString());




    }
}

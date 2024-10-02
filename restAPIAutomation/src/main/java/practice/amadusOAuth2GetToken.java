package practice;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;


public class amadusOAuth2GetToken {

    @Test
    public void getOAuth2AccessToken(){
        RestAssured.baseURI="https://test.api.amadeus.com";

        String token = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type","client_credentials")
                .formParam("client_id","ANw5IwJHDwjkg6JpFe3iqM5V2NqGCD60")
                .formParam("client_secret","CoSpe3ofLyfAKwED")
                .when()
                .post("/v1/security/oauth2/token")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract().response(). path("access_token");
        System.out.println("generated token : "+token);
    }
}

package practice;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class verifyUsingMatchers {

    @Test
    public void verifyBodyContent(){
        RestAssured.baseURI="http://gorest.co.in";

        int id = given()
                .header("Authorization","Bearer 507d4c7bcd56f7c675e03a63f7c58d2db935f7639a770544b4aa859110b24417")
                .when()
                .get("/public/v2/users")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract().path("[0].id");
        System.out.println("ID : "+id);
    }

    public void verifyBodyContentUsingMatchers(){
        RestAssured.baseURI="http://gorest.co.in";

        given()
                .header("Authorization","Bearer 507d4c7bcd56f7c675e03a63f7c58d2db935f7639a770544b4aa859110b24417")
                .when()
                .get("/public/v2/users/5914148")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id",is(notNullValue()))
                .and()
                .body("$.size()",hasSize(1))
                .and()
                .body("id",equalTo(5914148));
    }

    public void verifyBodyContentUsingMatchers_multiUser(){
        RestAssured.baseURI="http://gorest.co.in";

        given()
                .header("Authorization","Bearer 507d4c7bcd56f7c675e03a63f7c58d2db935f7639a770544b4aa859110b24417")
                .when()
                .get("/public/v2/users")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("$.id",is(notNullValue()))
                .and()
                .body("$.size()",hasSize(10))
                .and()
                .body("id",hasItem(5914148));
    }
}

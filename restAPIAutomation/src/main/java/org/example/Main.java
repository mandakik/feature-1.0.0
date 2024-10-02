package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Main {
    public static void main(String[] args) {

        RestAssured.baseURI="https://api.github.com/users/zellwk/repos";
int startPoint = (int)System.currentTimeMillis();
        Response response = RestAssured.given()
                .when().get()
                .then().extract().response();
        int endPoint = (int)System.currentTimeMillis();

        System.out.println("response time : "+(endPoint-startPoint));
/*                .assertThat()
                .statusCode(200);*/


                   }
}


  /*  API END POINT:
        https://api.github.com/users/zellwk/repos
        Send a get request
        print response time
        assertion on http status code*/
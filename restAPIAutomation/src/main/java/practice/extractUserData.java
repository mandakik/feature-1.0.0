package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.*;

public class extractUserData {

    @Test
    public void getAndExtractUserDetails(){
        RestAssured.baseURI="http://gorest.co.in";
        Response response = given()
               // .header("Authorization","Bearer 507d4c7bcd56f7c675e03a63f7c58d2db935f7639a770544b4aa859110b24417")
                .when()
                .get("/public/v2/users")
                .then()
                .extract().response();

        response.prettyPrint();
        JsonPath responseJson = response.jsonPath();
        System.out.println("ID : "+responseJson.getInt("[0].id"));
        System.out.println("name : "+responseJson.getString("[0].name"));

        List<Integer> IDs = responseJson.getList("id");
        List<String> nameList = responseJson.getList("name");

        for(int i=0; i<10; i++){
            System.out.println("ID : "+IDs.get(i)+" : "+"name : "+nameList.get(i));
        }
    }
}

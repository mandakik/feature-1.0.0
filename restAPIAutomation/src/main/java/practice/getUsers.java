package practice;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class getUsers {

    @Test
    public void getUsersTest(){
        RestAssured.baseURI="https://gorest.co.in/";

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.header("Content-Type","application/json");
        Response response = reqSpec.get("public/v2/users");

        //print body
        System.out.println(response.prettyPrint());
        //status
        System.out.println("status : "+response.statusCode());
        //statusline
        System.out.println("status msg : "+response.statusLine());
        //headers
        System.out.println("headers : "+response.header("Content-Type"));
        System.out.println("headers : "+response.header("Connection"));
        System.out.println(response.getHeaders().asList().size());

        List<Header> headerList = response.getHeaders().asList();
        for(Header h: headerList){
            System.out.println(h.getName()+" : "+h.getValue()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               );
        }
    }
}

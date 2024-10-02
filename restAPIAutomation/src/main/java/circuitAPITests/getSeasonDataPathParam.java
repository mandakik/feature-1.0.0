package circuitAPITests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getSeasonDataPathParam {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI="http://ergast.com";
    }

    @Test
    public void getCircuitIDs(){
        
        Response response = given()
                .pathParam("year",2016)
                
                .when()
                .get("/api/f1/{year}/circuits.json")
                .then().assertThat()
                .statusCode(200)
                .and().extract().response();

        List<String> circuitIds = response.jsonPath().getList("MRData.CircuitTable.Circuits.circuitId");

        System.out.println(circuitIds);
    }

    @DataProvider
    public Object[][] getSeasonData(){
        return new Object[][]{
                {"2016",21},
                {"2017",20},
                {"1966",9},
                {"2023",22}
        };
    }


    @Test(dataProvider="getSeasonData")
    public void getCircuitIds_dataprovider(String seasonYear, int totalCircuits){


        given()
                .pathParam("year",seasonYear)
                .when()
                .get("/api/f1/{year}/circuits.json")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("MRData.CircuitTable.Circuits.circuitId",hasSize(totalCircuits));
    }
}

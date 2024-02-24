package tests;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
    @Test
    public void test1(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());  // gamomitane status code
        System.out.println(response.getTime()); // dro ramdeni daschirda
        System.out.println(response.getBody().asString()); //gamoitane body stringshi
        System.out.println(response.getStatusLine()); // response headershi rac weria pirvel xazzze HTTP/1.1 200 OK
        System.out.println(response.getHeader("content-type")); // response headershi Content-Type: application/json; charset=utf-8
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);  // assertioni rom status code namdvilad emtxveva tu ara

    }
    @Test
    public void test2(){
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).  // rom gamomitanos json pormatshi yvela momxmarebeli
                body("data[1].id",equalTo(8)).log().all();
    }
}

package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PutPathDeleteExamples {
    @Test
    public void put(){
        JSONObject request = new JSONObject(); //update roca gvinda inpormaciis viyenebt puts
        request.put("name","Marikuwa");
        request.put("job","Tester");
        System.out.println(request.toJSONString()); // gamomitans json pormatshi chems saxels da samsaxurs
        baseURI = "https://reqres.in/api";
        given(). // dabechdavs response headers
                header("Content-Type","application/json"). // aq vuwert rom vemushavebit application/jsons
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2"). // aq vwert end points
                then().statusCode(200).log().all(); // responseshi rac unda daabrunos daabrunebs amas


    }
    @Test
    public void patch(){
        JSONObject request = new JSONObject(); //update roca gvinda inpormaciis viyenebt patchs
        request.put("name","Marikuwa");
        request.put("job","Tester");
        System.out.println(request.toJSONString()); // gamomitans json pormatshi chems saxels da samsaxurs
        baseURI = "https://reqres.in";
        given(). // dabechdavs response headers
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().statusCode(200).log().all(); // responseshi rac unda daabrunos daabrunebs amas


    }
    @Test
    public void Delete(){

        baseURI = "https://reqres.in";

                when().
                delete("/api/users/2").
                then().statusCode(204).log().all(); // washale da es statusi code sheamowme rom namdvilad waishala


    }

}

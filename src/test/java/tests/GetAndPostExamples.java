package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {
    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api";   // mtavari url
        given()
                .get("/users?page=2"). // j metershi pathshi rom vwert is nawili
                then().statusCode(200).     // aq rom status code 200 ia vamowmebt
                body("data[2].first_name", equalTo("Tobias")). //https://jsonpathfinder.com/ am saitze shevdivart path vipovit da shevadarebt im konkretuls
                body("data.first_name", hasItems("George", "Rachel"));

    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<String, Object>();  // obieqti shevqmeni
        map.put("name", "Mariami"); // aq jsonshi chavwere chemi saxeli da jobi
        map.put("job", "tester");
        System.out.println(map); // damibechde maps rac mienicha
        JSONObject request = new JSONObject(map);
        System.out.println(request);
        baseURI = "https://reqres.in/api";
        given(). // dabechdavs response headers
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().statusCode(201).log().all();


    }
}

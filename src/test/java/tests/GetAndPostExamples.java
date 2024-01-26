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
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).
                body("data[2].first_name", equalTo("Tobias")).
                body("data.first_name", hasItems("George", "Rachel"));

    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Mariami");
        map.put("job", "tester");
        System.out.println(map);
        JSONObject request = new JSONObject(map);
        System.out.println(request);
        baseURI = "https://reqres.in/api";
                given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                 body(request.toJSONString()).
                when().
                 post("/users").
                then().statusCode(201).log().all();


    }
}

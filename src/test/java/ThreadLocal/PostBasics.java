package ThreadLocal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostBasics {

    RequestSpecification httpRequest;

    @BeforeMethod
    public void setUp() {
        System.out.println("------------Set up before method------");

        RestAssured.baseURI = "http://localhost:5002/";
        RestAssured.basePath = "api/members";

        Header acceptHeader = new Header("Accept", "application/json");
        Header contentTypeHeader = new Header("Content-Type", "application/json");

        List<Header> headers = new ArrayList<>();
        headers.add(acceptHeader);
        headers.add(contentTypeHeader);

        Headers allheaders = new Headers(headers);

        httpRequest = RestAssured.given().auth().basic("admin", "admin").headers(allheaders).log().all();


    }

    @Test(enabled = false)
    public void createMember() {
        String body = "{\n" +
                "    \"name\": \"David\",\n" +
                "    \"gender\": \"Male\"\n" +
                "}";

        httpRequest.body(body);

        Response response = httpRequest.post();
        System.out.println(response.asPrettyString());
//        RestAssured.given().body(body).auth().basic("admin", "admin").header("Content-Type", ContentType.JSON).log().all().when().post().then().log().all().extract().response();


    }

    @Test(enabled = false)
    public void createMemberBĐ() {
        String body = "{\n" +
                "    \"name\": \"David\",\n" +
                "    \"gender\": \"Male\"\n" +
                "}";

        Response response = httpRequest.body(body).when().post().andReturn();
        System.out.println(response.asPrettyString());
    }

    @Test(enabled = true)
    public void createMemberMapBDD() {

        Member member = new Member("Steve", "male");
//        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//        String body = gson.toJson(member);
//        Response response = httpRequest.body(body).when().post().andReturn();
//        System.out.println(response.asPrettyString());


    }


}

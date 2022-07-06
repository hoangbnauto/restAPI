package ThreadLocal.GoogleOAuth;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GmailApi {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token = "ya29.a0ARrdaM916BvQKHwj3sGYcG7nOmPloGv5eNyS6c3femnUVOQh7sTT1KbMXg4lwN66G87GR-61f_aNnWu81u3wpbD4sAlfFT-Hk2JZ0f8-fnF1Zbf0KsKikRC-Aucil_3vynMMdmo-F3Zv9eqLn-BKN6m3Mk0C";

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://gmail.googleapis.com").
                addHeader("Authorization", "Bearer " + access_token).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();

    }

    @Test(enabled = false)
    public void getUserProfile(){
        given(requestSpecification).basePath("gmail/v1/").
                pathParams("userid", "bui.nguyenhoang93@gmail.com").
                when().get("users/{userid}/profile").
                then().spec(responseSpecification);

    }

    @Test(enabled = true)
    public void sendMessage(){

        String message = "From: bui.nguyenhoang93@gmail.com\n" +
                "To: hoangbui.ktmt@gmail.com\n" +
                "Subject: Rest test\n" +
                "\n" +
                "Sending from rest\n";
        String base64UrlEncoding = Base64.getUrlEncoder().encodeToString(message.getBytes());

        Map<String, String> body = new HashMap<>();
        body.put("raw", base64UrlEncoding);

        given(requestSpecification).basePath("gmail/v1/").
                pathParams("userid", "bui.nguyenhoang93@gmail.com").
                body(body).
                when().post("users/{userid}/messages/send").
                then().spec(responseSpecification);
    }
}

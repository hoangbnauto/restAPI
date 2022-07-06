package com.spotify.oauth2.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

import static com.spotify.oauth2.api.RestResource.postAcount;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;


    public static String getToken() {
        try {
            if (access_token == null || Instant.now().isAfter(expiry_time)) {
                System.out.println("renew token");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationSeconds);
            } else {
                System.out.println("Token is good to use");
            }


        } catch (Exception e) {
            throw new RuntimeException("ABORT");
        }

        return access_token;
    }

    private static Response renewToken() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "refresh_token");
        formParams.put("refresh_token", "AQC0ty324awLDJ9znhXLcrkha910xcMbc6EI7ymuQMpSjAnJcY0DgLpZdwyinAgKQHrNcM3TLVuC13Iwg8wW17c4-L8BWoVuKTUo_VT1YetWm5XfWMcym-jBzfxPdPvZ4eo");
        formParams.put("client_id", "fd59282a43064681a06b2f534eecf599");
        formParams.put("client_secret", "43abe9526f1941af85d7e79026a95aff");

        Response response = RestResource.postAcount(formParams);

        if (response.statusCode() != 200) {
            throw new RuntimeException("ERROR");
        }
        return response;
    }
}

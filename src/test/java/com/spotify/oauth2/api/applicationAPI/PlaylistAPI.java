package com.spotify.oauth2.api.applicationAPI;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static com.spotify.oauth2.api.TokenManager.getToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlaylistAPI {
    static String access_token = "BQCbH9Ee0qMewMMX1mUohCP1FX7riQ580Qlsj-gL323-UEkIzD4gyNGw9Eg5HrreQepiFz2545dfZTgJbvzLdvqLGejivXcapOM7dWWosrNQ-W43fCXCddOb-JAwWnDABP8wk88RTUSwq8wLNAP-ij-jCumUniWjg-QbvxPK5Px2kAZ8KeuWOfTptXX0rJiqtdpD6m9alFcL8H84IjXcc7pBsG9oGg3-J2YPpv4gSat2UpN6ZD_c4fe5lQGnbj28OGXutBkk-BoulRno";

    public static Response post(Playlist requestPlaylist){
        return RestResource.post("/users/31zkx3xipsef44nfjei7vrgsd23y/playlists", getToken(), requestPlaylist);
    }

    public static Response post(String token, Playlist requestPlaylist){
        return RestResource.post("/users/31zkx3xipsef44nfjei7vrgsd23y/playlists", token, requestPlaylist);
    }

    public static Response get(String playlistID){
        return RestResource.get("/playlists/" + playlistID, getToken());
    }

    public static Response update(Playlist requestPlaylist, String playlistID){
        return RestResource.update("/playlists/" + playlistID, getToken(), requestPlaylist);


    }
}

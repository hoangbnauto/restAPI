package com.spotify.oauth2.test;

import com.spotify.oauth2.api.applicationAPI.PlaylistAPI;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PlaylistTest {

    @Test
    public void shouldBeAbleToCreatePlayList() {
        Playlist requestPlaylist = new Playlist();
        requestPlaylist.setName("New Playlist Rest POJO").setDescription("For testing purpose").setPublic(false);
        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(201));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo("New Playlist Rest POJO"));
        assertThat(responsePlaylist.getDescription(), equalTo("For testing purpose"));
        assertThat(responsePlaylist.getPublic(), equalTo(false));
    }


    @Test
    public void shouldAbleToGetPlayList() {
        Playlist requestPlaylist = new Playlist();
        requestPlaylist.setName("New Playlist Update POJO").setDescription("For testing purpose").setPublic(false);

        Response response = PlaylistAPI.get("2teN7KDRfDyZwGbHq398tS");
        assertThat(response.statusCode(), equalTo(200));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));

    }

    @Test
    public void shouldAbleToUpdatePlaylist() {
        Playlist requestPlaylist = new Playlist();
        requestPlaylist.setName("New Playlist Update POJO").setDescription("For testing purpose").setPublic(false);

        Response response = PlaylistAPI.update(requestPlaylist, "2teN7KDRfDyZwGbHq398tS");
        assertThat(response.statusCode(), equalTo(200));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));

    }

    @Test
    public void shouldNotBeAbleToCreatePlayListWithName() {
        Playlist requestPlaylist = new Playlist();
        requestPlaylist.setName("").setDescription("For testing purpose").setPublic(false);


        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(400));

        Error error = response.as(Error.class);
        assertThat(error.getError().getStatus(), equalTo(400));
        assertThat(error.getError().getMessage(), equalTo("Missing required field: name"));
    }

    @Test
    public void shouldNotBeAbleToCreatePlaylistWithExpiredToken(){
        String invalid_Token = "123123";
        Playlist requestPlaylist = new Playlist();
        requestPlaylist.setName("New Playlist Update POJO").setDescription("For testing purpose").setPublic(false);

        Response response = PlaylistAPI.post(invalid_Token, requestPlaylist);
        assertThat(response.statusCode(), equalTo(401));

        Error error = response.as(Error.class);

        assertThat(error.getError().getStatus(), equalTo(401));
        assertThat(error.getError().getMessage(), equalTo("Invalid access token"));
    }
}

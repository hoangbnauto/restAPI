package com.spotify.oauth2.test;

import java.time.Instant;

public class Test {
    private static Instant time;
    public static void main(String[] args) {
        time = Instant.now().plusSeconds(3600);
        System.out.println(Instant.now().isAfter(time));
    }
}

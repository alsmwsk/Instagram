package com.example.seowoo.instagram.Utils;

public class StringManipulation {

    public static String expandUsername(String username) {
        return username.replace(".", " ");
    }

    public static String condenseUsername(String username){
        return username.replace(" ",".");
    }
}

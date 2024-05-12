package com.librarymanagement.utils;

import java.util.UUID;

public class StringHelper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String generateUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}

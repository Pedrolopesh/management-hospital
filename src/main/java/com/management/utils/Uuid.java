package com.management.utils;

import java.util.UUID;

public class Uuid {

    public String generateId(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }
}

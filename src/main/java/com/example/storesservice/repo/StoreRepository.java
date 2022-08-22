package com.example.storesservice.repo;

import com.example.storesservice.exception.JsonFileNotFoundException;
import com.example.storesservice.model.Stores;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class StoreRepository {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public Stores getAllStores() throws JsonFileNotFoundException {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            return objectMapper.readValue(new File("src/main/resources/stores.json"), Stores.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonFileNotFoundException("File no found");
        }
    }
}

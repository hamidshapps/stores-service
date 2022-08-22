package com.example.storesservice.service;

import com.example.storesservice.controller.dto.StoreDistance;
import com.example.storesservice.controller.dto.StoresDistance;
import com.example.storesservice.converter.StoreMapper;
import com.example.storesservice.exception.JsonFileNotFoundException;
import com.example.storesservice.model.Stores;
import com.example.storesservice.repo.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoresService {

    private final StoreMapper storeMapper;

    private final StoreRepository storeRepository;

    public StoresService(StoreMapper storeMapper, StoreRepository storeRepository) {
        this.storeMapper = storeMapper;
        this.storeRepository = storeRepository;
    }

    public StoresDistance getFiveClosestStores(double latitude, double longitude) throws JsonFileNotFoundException {
        Stores stores = storeRepository.getAllStores();
        List<StoreDistance> storesDistances = storeMapper.toStoresDistance(stores, latitude, longitude);
        List<StoreDistance> fiveClosestStores = storesDistances.stream().sorted().limit(5).collect(Collectors.toList());
        return new StoresDistance(fiveClosestStores);
    }
}


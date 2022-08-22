package com.example.storesservice.converter;

import com.example.storesservice.controller.dto.StoreDistance;
import com.example.storesservice.model.Store;
import com.example.storesservice.model.Stores;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreMapper {

    final int earthRadius = 6371;

    /**
     * This method add distance of given coordinates from corresponding store
     * @param stores Jumbo stores
     * @param latitude given latitude
     * @param longitude given longitude
     * @return list of stores with distance from given coordinates
     */
    public List<StoreDistance> toStoresDistance(Stores stores, double latitude, double longitude) {
        List<StoreDistance> storesDistances = new ArrayList<>();

        stores.getStores().forEach(store -> {
            double distance = calculateDistance(store, latitude, longitude);
            storesDistances.add(toDto(store, distance));
        });
        return storesDistances;
    }

    /**
     * The distance of coordinate based on the haversine formula
     * @param store the jumbo store object including long and lat
     * @param latitude the requested lat
     * @param longitude the requested lon
     * @return distance in meter
     */
    private double calculateDistance(Store store, double latitude, double longitude) {
        double tetaGivenLat = latitude * Math.PI / 180;
        double tetaJumboLat = store.getLatitude() * Math.PI / 180;
        double deltaTetta = (latitude - store.getLatitude()) * Math.PI / 180;
        double deltaLambda = (longitude - store.getLongitude()) * Math.PI / 180;

        double a = Math.sin(deltaTetta / 2) * Math.sin(deltaTetta / 2)
                + Math.cos(tetaGivenLat) * Math.cos(tetaJumboLat)
                * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c * 1000;
    }

    private StoreDistance toDto(Store store, double distance) {
        StoreDistance storeDto = new StoreDistance();
        storeDto.setCity(store.getCity());
        storeDto.setStreet(store.getStreet());
        storeDto.setAddressName(store.getAddressName());
        storeDto.setDistance(distance);
        storeDto.setTodayOpen(store.getTodayOpen());
        storeDto.setTodayClose(store.getTodayClose());
        storeDto.setPostalCode(store.getPostalCode());
        return storeDto;
    }
}

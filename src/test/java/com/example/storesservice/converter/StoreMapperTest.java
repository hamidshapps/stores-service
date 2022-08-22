package com.example.storesservice.converter;

import com.example.storesservice.controller.dto.StoreDistance;
import com.example.storesservice.model.Store;
import com.example.storesservice.model.Stores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StoreMapperTest {

    @InjectMocks
    private StoreMapper storeMapper;

    @Test
    void mapAndCalculateStoresToStoresDto() {
        Stores stores = getMockStores();
        List<StoreDistance> storesDtoResult = storeMapper.toStoresDistance(stores, 52.075291, 4.320230);

        assertEquals(10, storesDtoResult.size());
        assertEquals(3628.2354641670095, storesDtoResult.get(0).getDistance());
    }

    private Stores getMockStores() {
        List<Store> stores = Arrays.asList(
                new Store("city1", "postalCode1", "Street", "street2", "street3", "addressName1", "uui1", 52.093880, 4.276590, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city2", "postalCode2", "Street", "street2", "street3", "addressName2", "uui1", 3.0, 4.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city3", "postalCode3", "Street", "street2", "street3", "addressName3", "uui1", 5.0, 6.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city4", "postalCode4", "Street", "street2", "street3", "addressName4", "uui1", 7.0, 7.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city5", "postalCode5", "Street", "street2", "street3", "addressName5", "uui1", 8.0, 8.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city6", "postalCode6", "Street", "street2", "street3", "addressName6", "uui1", 9.0, 9.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city7", "postalCode7", "Street", "street2", "street3", "addressName7", "uui1", 10.0, 10.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city8", "postalCode8", "Street", "street2", "street3", "addressName8", "uui1", 11.0, 11.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city9", "postalCode9", "Street", "street2", "street3", "addressName9", "uui1", 12.0, 12.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00"),
                new Store("city10", "postalCode10", "Street", "street2", "street3", "addressName10", "uui1", 13.0, 13.0, "complexNumber1", true, "7:00", "locationType1", true, 1L, "19:00")
        );
        return new Stores(stores);
    }
}

package com.example.storesservice.service;

import com.example.storesservice.controller.dto.StoreDistance;
import com.example.storesservice.controller.dto.StoresDistance;
import com.example.storesservice.converter.StoreMapper;
import com.example.storesservice.repo.StoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StoresServiceTest {

    @InjectMocks
    private StoresService storesService;

    @Mock
    private StoreMapper storeMapper;

    @Mock
    private StoreRepository storeRepository;

    @Test
    void getStoresFiveClosestStore() {
        List<StoreDistance> storesDistance = getMockStoresDto();

        when(storeMapper.toStoresDistance(any(), anyDouble(), anyDouble())).thenReturn(storesDistance);
        StoresDistance fiveStoresResult = storesService.getFiveClosestStores(1.0, 1.0);

        assertEquals(5, fiveStoresResult.getStores().size());
        assertEquals("city9", fiveStoresResult.getStores().get(0).getCity());
        assertEquals(1.1, fiveStoresResult.getStores().get(0).getDistance());
        assertEquals(2.0, fiveStoresResult.getStores().get(1).getDistance());
    }

    private List<StoreDistance> getMockStoresDto() {
        return Arrays.asList(
                new StoreDistance("city1", "postalCode1", "Street", "addressName1", "7:00", "19:00", 2.0),
                new StoreDistance("city2", "postalCode2", "Street", "addressName2", "7:00", "19:00", 20.0),
                new StoreDistance("city3", "postalCode3", "Street", "addressName3", "7:00", "19:00", 3.0),
                new StoreDistance("city4", "postalCode4", "Street", "addressName4", "7:00", "19:00", 22.0),
                new StoreDistance("city5", "postalCode5", "Street", "addressName5", "7:00", "19:00", 4.6),
                new StoreDistance("city6", "postalCode6", "Street", "addressName6", "7:00", "19:00", 27.0),
                new StoreDistance("city7", "postalCode7", "Street", "addressName7", "7:00", "19:00", 5.01),
                new StoreDistance("city8", "postalCode8", "Street", "addressName8", "7:00", "19:00", 33.1),
                new StoreDistance("city9", "postalCode9", "Street", "addressName9", "7:00", "19:00", 1.1),
                new StoreDistance("city10", "postalCode10", "Street", "addressName0", "7:00", "19:00", 29.0)
        );
    }
}

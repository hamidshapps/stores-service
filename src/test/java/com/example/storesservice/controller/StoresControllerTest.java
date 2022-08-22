package com.example.storesservice.controller;

import com.example.storesservice.controller.dto.StoreDistance;
import com.example.storesservice.controller.dto.StoresDistance;
import com.example.storesservice.service.StoresService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class StoresControllerTest {

    @InjectMocks
    private StoresController storesController;

    @MockBean
    private StoresService storesService;

    @Test
    void getFiveClosestStores() {
        StoresController storesController = new StoresController(storesService);
        StoresDistance expectedStores = new StoresDistance(Arrays.asList(
                new StoreDistance("city1", "postalCode1", "street1", "address 1", "08:00", "18:00", 1.0),
                new StoreDistance("city2", "postalCode2", "street1", "address 1", "08:00", "18:00", 2.0),
                new StoreDistance("city3", "postalCode3", "street1", "address 1", "08:00", "18:00", 3.0),
                new StoreDistance("city4", "postalCode4", "street1", "address 1", "08:00", "18:00", 4.0),
                new StoreDistance("city5", "postalCode5", "street1", "address 1", "08:00", "18:00", 5.0)
        ));

        when(storesService.getFiveClosestStores(1.0, 2.0)).thenReturn(expectedStores);
        assertEquals(5, Objects.requireNonNull(storesController.getFiveClosestStores(1.0, 2.0).getBody()).getStores().size());
        assertEquals(1.0, Objects.requireNonNull(storesController.getFiveClosestStores(1.0, 2.0).getBody()).getStores().get(0).getDistance());
    }
}

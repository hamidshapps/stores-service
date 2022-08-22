package com.example.storesservice.controller;

import com.example.storesservice.controller.dto.StoreDistance;
import com.example.storesservice.controller.dto.StoresDistance;
import com.example.storesservice.service.StoresService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StoresControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoresService storesService;

    @Test
    void getFiveClosestStores() throws Exception {
        StoresDistance expectedStores = getStoresWithDistanceMock();
        when(storesService.getFiveClosestStores(1.0, 1.0))
                .thenReturn(expectedStores);
        mockMvc.perform(get("/stores/five-closest")
                        .param("latitude", "1.0")
                        .param("longitude", "1.0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stores.length()").value(5))
                .andExpect(jsonPath("$.stores[0].city").value("city1"))
                .andExpect(jsonPath("$.stores[0].distance").value("1.0"))
                .andExpect(jsonPath("$.stores[4].city").value("city5"))
                .andExpect(jsonPath("$.stores[4].distance").value("5.0"));


        verify(storesService).getFiveClosestStores(1.0, 1.0);
    }

    private StoresDistance getStoresWithDistanceMock() {
        return new StoresDistance(Arrays.asList(
                new StoreDistance("city1", "postalCode1", "street1", "address 1", "08:00", "18:00", 1.0),
                new StoreDistance("city2", "postalCode2", "street1", "address 1", "08:00", "18:00", 2.0),
                new StoreDistance("city3", "postalCode3", "street1", "address 1", "08:00", "18:00", 3.0),
                new StoreDistance("city4", "postalCode4", "street1", "address 1", "08:00", "18:00", 4.0),
                new StoreDistance("city5", "postalCode5", "street1", "address 1", "08:00", "18:00", 5.0)
        ));
    }

}

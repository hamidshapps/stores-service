package com.example.storesservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StoresControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFiveClosestJumboToGivenCoordinate() throws Exception {

        mockMvc.perform(get("/stores/five-closest")
                        .param("latitude", "52.075291")
                        .param("longitude", "4.320230"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stores.length()").value(5))
                .andExpect(jsonPath("$.stores[0].city").value("Den Haag"))
                .andExpect(jsonPath("$.stores[0].distance").value("1120.4137835438646"))
                .andExpect(jsonPath("$.stores[4].city").value("Den Haag"))
                .andExpect(jsonPath("$.stores[4].distance").value("4196.520072761643"));
    }

}

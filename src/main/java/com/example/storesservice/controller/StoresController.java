package com.example.storesservice.controller;

import com.example.storesservice.controller.dto.StoresDistance;
import com.example.storesservice.exception.JsonFileNotFoundException;
import com.example.storesservice.service.StoresService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/stores")
public class StoresController {

    private final StoresService distanceService;

    public StoresController(StoresService distanceService) {
        this.distanceService = distanceService;
    }

    @Operation(description = "Get five closest Jumbo stores to a given coordinate")
    @GetMapping("/five-closest")
    public ResponseEntity<StoresDistance> getFiveClosestStores(
            @RequestParam @NotNull Double latitude,
            @RequestParam @NotNull Double longitude
    ) throws JsonFileNotFoundException {
        return new ResponseEntity<>(distanceService.getFiveClosestStores(latitude, longitude), HttpStatus.OK);
    }
}

package com.example.storesservice.controller.dto;

import java.util.List;

public class StoresDistance {
    private List<StoreDistance> stores;

    public StoresDistance(List<StoreDistance> stores) {
        this.stores = stores;
    }

    public List<StoreDistance> getStores() {
        return stores;
    }

    public void setStores(List<StoreDistance> stores) {
        this.stores = stores;
    }
}

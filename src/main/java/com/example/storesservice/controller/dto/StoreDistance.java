package com.example.storesservice.controller.dto;

public class StoreDistance implements Comparable<StoreDistance>{
    private String city;
    private String postalCode;
    private String street;
    private String addressName;
    private String todayOpen;
    private String todayClose;
    private double distance;

    public StoreDistance() {
    }

    public StoreDistance(String city, String postalCode, String street, String addressName, String todayOpen, String todayClose, double distance) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.addressName = addressName;
        this.todayOpen = todayOpen;
        this.todayClose = todayClose;
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getTodayOpen() {
        return todayOpen;
    }

    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }

    public String getTodayClose() {
        return todayClose;
    }

    public void setTodayClose(String todayClose) {
        this.todayClose = todayClose;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(StoreDistance o) {
        return Double.compare(distance, o.distance);
    }
}


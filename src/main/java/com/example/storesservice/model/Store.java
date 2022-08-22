package com.example.storesservice.model;

public class Store {
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private String uuid;
    private double longitude;
    private double latitude;
    private String complexNumber;
    private Boolean showWarningMessage;
    private String todayOpen;
    private String locationType;
    private Boolean collectionPoint;
    private Long sapStoreID;
    private String todayClose;

    public Store() {
    }

    public Store(String city,
                 String postalCode,
                 String street,
                 String street2,
                 String street3,
                 String addressName,
                 String uuid,
                 double latitude,
                 double longitude,
                 String complexNumber,
                 Boolean showWarningMessage,
                 String todayOpen,
                 String locationType,
                 Boolean collectionPoint,
                 Long sapStoreID,
                 String todayClose) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.street2 = street2;
        this.street3 = street3;
        this.addressName = addressName;
        this.uuid = uuid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.complexNumber = complexNumber;
        this.showWarningMessage = showWarningMessage;
        this.todayOpen = todayOpen;
        this.locationType = locationType;
        this.collectionPoint = collectionPoint;
        this.sapStoreID = sapStoreID;
        this.todayClose = todayClose;
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

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(String complexNumber) {
        this.complexNumber = complexNumber;
    }

    public Boolean getShowWarningMessage() {
        return showWarningMessage;
    }

    public void setShowWarningMessage(Boolean showWarningMessage) {
        this.showWarningMessage = showWarningMessage;
    }

    public String getTodayOpen() {
        return todayOpen;
    }

    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Boolean getCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(Boolean collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    public Long getSapStoreID() {
        return sapStoreID;
    }

    public void setSapStoreID(Long sapStoreID) {
        this.sapStoreID = sapStoreID;
    }

    public String getTodayClose() {
        return todayClose;
    }

    public void setTodayClose(String todayClose) {
        this.todayClose = todayClose;
    }
}

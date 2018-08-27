package com.projects.nouran.foodcourt.main.pojos;

import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("StoreID")
    private int storeId;

    @SerializedName("StoreName")
    private String storeName;

    @SerializedName("StoreDescription")
    private String StoreDescription;

    @SerializedName("StoreLogo")
    private String storeLogo;

    public int getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreDescription() {
        return StoreDescription;
    }

    public String getStoreLogo() {
        return storeLogo;
    }
}

package com.testing.rest_service.swagger;

public class AddProductReq {

    private long id;

    private long addQty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAddQty() {
        return addQty;
    }

    public void setAddQty(long addQty) {
        this.addQty = addQty;
    }
}

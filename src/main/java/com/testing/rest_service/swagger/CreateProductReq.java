package com.testing.rest_service.swagger;

public class CreateProductReq {

    private long id;

    private long qty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }
}

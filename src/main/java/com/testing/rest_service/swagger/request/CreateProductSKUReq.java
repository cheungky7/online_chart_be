package com.testing.rest_service.swagger.request;

import com.testing.rest_service.domain.entities.Product;

public class CreateProductSKUReq {

    private Double price;
    private Integer quantityInStock;

    private Long waveHouseId;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Long getWaveHouseId() {
        return waveHouseId;
    }

    public void setWaveHouseId(Long waveHouseId) {
        this.waveHouseId = waveHouseId;
    }
}

package com.testing.rest_service.swagger.dto;

import com.testing.rest_service.domain.entities.Product;

public class ProductSKUDTO {

    private Long skuId;

    //private Product productDTO;

    private Double price;
    private Integer quantityInStock;

    private Long waveHouseId;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
/*
    public Product getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(Product productDTO) {
        this.productDTO = productDTO;
    }
*/
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

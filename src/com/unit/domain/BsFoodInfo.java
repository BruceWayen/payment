package com.unit.domain;

import java.util.Date;

public class BsFoodInfo {
    private Long id;

    private String foodName;

    private String foodDesc;

    private Integer busiNo;

    private Integer price;

    private Integer status;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc == null ? null : foodDesc.trim();
    }

    public Integer getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(Integer busiNo) {
        this.busiNo = busiNo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
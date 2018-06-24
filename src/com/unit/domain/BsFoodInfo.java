package com.unit.domain;

public class BsFoodInfo {
    private Long id;

    private String foodName;

    private String foodDesc;

    private String busiNo;

    private String price;

    private String status;

    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName()
    {
        return foodName;
    }

    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    public String getFoodDesc()
    {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc)
    {
        this.foodDesc = foodDesc;
    }

    public String getBusiNo()
    {
        return busiNo;
    }

    public void setBusiNo(String busiNo)
    {
        this.busiNo = busiNo;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
}
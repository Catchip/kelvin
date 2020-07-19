package grp.team7.kelvin.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Dish {

    //@JSONField(name="dishId")
    private Integer dishId;//菜品ID
    //@JSONField(name="dishName")
    private String dishName;//菜品名称
    //@JSONField(name="price")
    private Float price;//菜品价格
    //@JSONField(name="shopId")
    private Integer shopId;//所属店铺
    //@JSONField(name="dishClass")
    private String dishClass;//菜品类别
    //@JSONField(name="dishPicture")
    private String dishPicture; //图片路径
    //@JSONField(name="status")
    private Boolean status; //上架或下架

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    
    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDishId() {
        return dishId;
    }
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getDishPicture() {
        return dishPicture;
    }

    public void setDishPicture(String dishPicture) {
        this.dishPicture = dishPicture;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setDishClass(String dishClass) {
        this.dishClass = dishClass;
    }
    public String getDishClass() {
        return dishClass;
    }



}

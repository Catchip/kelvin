package grp.team7.kelvin.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderItem {
    private Integer id;
    private Integer orderId;
    private Integer dishId;
    private Float dishPrice;
    private Integer dishNum;
    private String dishClass;
    private String dishPicture;
    private String dishName;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Float getDishPrice() {
        return dishPrice;
    }
    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }
    public Integer getDishNum() {
        return dishNum;
    }
    public void setDishNum(Integer dishNum) {
        this.dishNum = dishNum;
    }
    public String getDishClass() {
        return dishClass;
    }
    public void setDishClass(String dishClass) {
        this.dishClass = dishClass;
    }
    public Integer getDishId() {
        return dishId;
    }
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }
    public String getDishPicture() {
        return dishPicture;
    }
    public void setDishPicture(String dishPicture) {
        this.dishPicture = dishPicture;
    }
    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

}

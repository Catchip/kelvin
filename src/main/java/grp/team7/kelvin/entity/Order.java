package grp.team7.kelvin.entity;

import java.util.Date;

public class Order {
    public Integer orderId; //订单号
    public Integer userId;//消费用户ID
    public Integer shopId;//店铺ID
    public Date orderCreatetime;//订单创立时间
    public Float money;//消费的金钱
    public Boolean isConsumed;//订单是否已经消费
    public String UUID;//验证码

    public Order(Integer orderId, Integer userId, Integer shopId, Float money, Boolean isConsumed) {
        this.orderId = orderId;
        this.userId = userId;
        this.shopId = shopId;
        this.money = money;
        this.isConsumed = isConsumed;
        Date date = new Date();
        this.orderCreatetime = date;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getShopId() {
        return shopId;
    }
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    public Float getMoney() {
        return money;
    }
    public void setMoney(Float money) {
        this.money = money;
    }
    public Date getOrderCreatetime() {
        return orderCreatetime;
    }
    public void setOrderCreatetime(Date orderCreatetime) {
    }

}

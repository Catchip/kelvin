package grp.team7.kelvin.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Order {
    @JSONField(name="orderId")
    public Integer orderId; //订单号
    @JSONField(name="userId")
    public Integer userId;//消费用户ID
    @JSONField(name="shopId")
    public Integer shopId;//店铺ID
    @JSONField(name="orderCreatetime")
    public Date orderCreatetime;//订单创立时间
    @JSONField(name="money")
    public Float money;//消费的金钱
    @JSONField(name="isConsumed")
    public Boolean isConsumed;//订单是否已经消费
    @JSONField(name="UUID")
    public String UUID;//验证码

    public Order(Integer userId, Integer shopId, Float money, Boolean isConsumed) {
        this.userId = userId;
        this.shopId = shopId;
        this.money = money;
        this.isConsumed = isConsumed;
        Date date = new Date();
        this.orderCreatetime = date;
    }
    public Order(){

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

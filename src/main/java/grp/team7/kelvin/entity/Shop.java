package grp.team7.kelvin.entity;

import  java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import java.lang.Integer;
import java.sql.Time;

public class Shop{

    @JSONField(name="shopId")
    private Integer shopId; //商铺ID
    @JSONField(name="shopName")
    private String shopName; //商铺名称
    @JSONField(name="shopClass")
    private String shopClass; //商铺类别
    @JSONField(name="shopAddress")
    private String shopAddress; //商铺地址
    @JSONField(name="shopPicture")
    private String shopPicture; //商铺图片路径
    @JSONField(name="userId")
    private Integer userId; //归属者用户id
    @JSONField(name="shopTelephone")
    private String shopTelephone;//商铺联系电话
    @JSONField(name="shopCreatetime")
    private Date shopCreatetime;//商铺创建时间
    @JSONField(name="shopUpdatetime")
    private Date shopUpdatetime;//最后一次修改店铺信息时间
    @JSONField(name="shopStarttime")
    private Time shopStarttime; //每日开张时间
    @JSONField(name="shopEndtime")
    private Time shopEndtime; //每日打烊日期
        

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTelephone() {
        return shopTelephone;
    }

    public void setShopTelephone(String shopTelphone) {
        this.shopTelephone = shopTelphone;
    }

    public Date getShopUpdatetime() {
        return shopUpdatetime;
    }

    public void setShopUpdatetime(Date shopUpdatetime) {
        this.shopUpdatetime = shopUpdatetime;
    }

    public void setShopClass(String shopClass) {
        this.shopClass = shopClass;
    }

    public String getShopClass() {
        return shopClass;
    }

    public Date getShopCreatetime() {
        return shopCreatetime;
    }

    public void setShopCreatetime(Date shopCreatetime) {
        this.shopCreatetime = shopCreatetime;
    }
    
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String address) {
        this.shopAddress = address;
    }
    
    public String getShopPicture() {
        return shopPicture;
    }

    public void setShopPicture(String shopPicture) {
        this.shopPicture = shopPicture;
    }

    public Time getshopStarttime() {
        return shopStarttime;
    }

    public void setshoptarttime(Time startTime) {
        this.shopStarttime = startTime;
    }

    public Time getShopEndtime() {
        return shopEndtime;
    }

    public void setShopEndtime(Time endTime) {
        this.shopEndtime = endTime;
    }


    

}

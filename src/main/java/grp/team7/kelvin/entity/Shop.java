package grp.team7.kelvin.entity;

import  java.util.Date;
import java.lang.Integer;
import java.sql.Time;

public class Shop{

	private Integer shopId; //商铺ID
	private String shopName; //商铺名称
	private String shopClass; //商铺类别
	private String shopAddress; //商铺地址
	private String shopPicture; //商铺图片路径
	private Integer userId; //归属者用户id
	private String shopTelephone;//商铺联系电话
	private Date shopCreatetime;//商铺创建时间
	private Date shopUpdatetime;//最后一次修改店铺信息时间
	private Time startTime; //每日开张时间
	private Time endTime; //每日打烊日期
		
	public Shop(){
	}

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

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}


	

}

package grp.team7.kelvin.entity;

import java.util.Date;

public class Dish {
	private Integer dishId;//菜品ID
	private String dishName;//菜品名称
	private Float price;//菜品价格
	private Integer shopId;//所属店铺
	private String dishClass;//菜品类别
	private String dishPicture; //图片路径
	private Boolean status; //上架或下架

	public Dish() {
		
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

	public String getDishPicture() {
		return dishPicture;
	}

	public void setDishPicture(String dishPicture) {
		this.dishPicture = dishPicture;
	}

	public void setIsOn(Boolean status) {
		this.status = status;
	}

	public Boolean getIsOn() {
		return status;
	}
	public void setDishClass(String dishClass) {
		this.dishClass = dishClass;
	}
	public String getDishClass() {
		return dishClass;
	}



}

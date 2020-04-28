package com.FruitsVegetablesMallServer.pojo;

public class GoodsDetail {
	private int id;
	private String imageUrls;
	private int categoryId;
	private String name;
	private Double price;
	private Double stock;
	private String specification;
	private Double reducedPrice;
	private Double minimunOrderQuantity;
	private Double maximumOrderQuantity;
	private Double minimumIncrementQuantity;
	private String detail;
	private String hotGoods;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Double getReducedPrice() {
		return reducedPrice;
	}
	public void setReducedPrice(Double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
	public Double getMinimunOrderQuantity() {
		return minimunOrderQuantity;
	}
	public void setMinimunOrderQuantity(Double minimunOrderQuantity) {
		this.minimunOrderQuantity = minimunOrderQuantity;
	}
	public Double getMaximumOrderQuantity() {
		return maximumOrderQuantity;
	}
	public void setMaximumOrderQuantity(Double maximumOrderQuantity) {
		this.maximumOrderQuantity = maximumOrderQuantity;
	}
	public Double getMinimumIncrementQuantity() {
		return minimumIncrementQuantity;
	}
	public void setMinimumIncrementQuantity(Double minimumIncrementQuantity) {
		this.minimumIncrementQuantity = minimumIncrementQuantity;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getHotGoods() {
		return hotGoods;
	}
	public void setHotGoods(String hotGoods) {
		this.hotGoods = hotGoods;
	}
	
	
}

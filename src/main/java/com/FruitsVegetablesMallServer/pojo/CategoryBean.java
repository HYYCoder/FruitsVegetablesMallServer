package com.FruitsVegetablesMallServer.pojo;
public class CategoryBean{
		private int id;
		private int orders;
		private String name;
		private String imageUrl;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getOrders() {
			return orders;
		}
		public void setOrders(int orders) {
			this.orders = orders;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
	}
package com.FruitsVegetablesMallServer.pojo;
public class SubCategoriesBean{
		private int id;
		private int pid;
		private int orders;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
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
	}
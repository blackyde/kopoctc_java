package com.twice.dto;

import java.sql.Timestamp;

public class Twice {
	
	private int goods_id;
	private String goods_name;
	private int stock;
	private Timestamp u_date;
	private Timestamp c_date;
	private String describe;
	private String image;
	
	public Twice() {
		// TODO Auto-generated constructor stub
	}
	
	public Twice(String goods_name,
			int stock, String describe, String image) {
		this.goods_name = goods_name;
		this.stock = stock;
		this.describe = describe;
		this.image = image;
	}

	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Timestamp getU_date() {
		return u_date;
	}
	public void setU_date(Timestamp u_date) {
		this.u_date = u_date;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}

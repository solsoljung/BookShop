package com.sol.vo;

import java.sql.Timestamp;

public class BuyVo {

	private int buy_info_num;
	private Timestamp buy_date;
	private int book_num;
	private int book_amount;
	private String mem_id;
	private String book_name;
	private String book_image;
	private int book_price;
	private String mem_phone;
	private String mem_address;
	public BuyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BuyVo(int buy_info_num, Timestamp buy_date, int book_num, int book_amount, String mem_id, String book_name,
			String book_image, int book_price, String mem_phone, String mem_address) {
		super();
		this.buy_info_num = buy_info_num;
		this.buy_date = buy_date;
		this.book_num = book_num;
		this.book_amount = book_amount;
		this.mem_id = mem_id;
		this.book_name = book_name;
		this.book_image = book_image;
		this.book_price = book_price;
		this.mem_phone = mem_phone;
		this.mem_address = mem_address;
	}

	public int getBuy_info_num() {
		return buy_info_num;
	}
	public void setBuy_info_num(int buy_info_num) {
		this.buy_info_num = buy_info_num;
	}
	public Timestamp getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Timestamp buy_date) {
		this.buy_date = buy_date;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getBook_amount() {
		return book_amount;
	}
	public void setBook_amount(int book_amount) {
		this.book_amount = book_amount;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	@Override
	public String toString() {
		return "BuyVo [buy_info_num=" + buy_info_num + ", buy_date=" + buy_date + ", book_num=" + book_num
				+ ", book_amount=" + book_amount + ", mem_id=" + mem_id + ", book_name=" + book_name + ", book_image="
				+ book_image + ", book_price=" + book_price + ", mem_phone=" + mem_phone + ", mem_address="
				+ mem_address + "]";
	}
}

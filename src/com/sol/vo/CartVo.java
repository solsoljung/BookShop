package com.sol.vo;

public class CartVo {

	private int cart_num;
	private int book_num;
	private int book_amount;
	private String mem_id;
	private String book_name;
	private String book_image;
	private int book_price;
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartVo(int cart_num, int book_num, int book_amount, String mem_id, String book_name, String book_image,
			int book_price) {
		super();
		this.cart_num = cart_num;
		this.book_num = book_num;
		this.book_amount = book_amount;
		this.mem_id = mem_id;
		this.book_name = book_name;
		this.book_image = book_image;
		this.book_price = book_price;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
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
	@Override
	public String toString() {
		return "CartVo [cart_num=" + cart_num + ", book_num=" + book_num + ", book_amount=" + book_amount + ", mem_id="
				+ mem_id + ", book_name=" + book_name + ", book_image=" + book_image + ", book_price=" + book_price
				+ "]";
	}
}

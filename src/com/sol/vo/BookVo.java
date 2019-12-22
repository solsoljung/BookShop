package com.sol.vo;

public class BookVo {

	private int book_num;
	private String book_name;
	private int book_price;
	private String category_code;
	private String category_code_explain;
	private String book_explain;
	private String book_writer;
	private int book_score;
	private int book_sold_count;
	private String book_image;
	private int book_stock;
	private int book_amount;
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVo(int book_num, String book_name, int book_price, String category_code, String category_code_explain,
			String book_explain, String book_writer, int book_score, int book_sold_count, String book_image,
			int book_stock, int book_amount) {
		super();
		this.book_num = book_num;
		this.book_name = book_name;
		this.book_price = book_price;
		this.category_code = category_code;
		this.category_code_explain = category_code_explain;
		this.book_explain = book_explain;
		this.book_writer = book_writer;
		this.book_score = book_score;
		this.book_sold_count = book_sold_count;
		this.book_image = book_image;
		this.book_stock = book_stock;
		this.book_amount = book_amount;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getBook_explain() {
		return book_explain;
	}
	public void setBook_explain(String book_explain) {
		this.book_explain = book_explain;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public int getBook_score() {
		return book_score;
	}
	public void setBook_score(int book_score) {
		this.book_score = book_score;
	}
	public int getBook_sold_count() {
		return book_sold_count;
	}
	public void setBook_sold_count(int book_sold_count) {
		this.book_sold_count = book_sold_count;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public int getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}
	public String getCategory_code_explain() {
		return category_code_explain;
	}
	public void setCategory_code_explain(String category_code_explain) {
		this.category_code_explain = category_code_explain;
	}
	public int getBook_amount() {
		return book_amount;
	}
	public void setBook_amount(int book_amount) {
		this.book_amount = book_amount;
	}
	@Override
	public String toString() {
		return "BookVo [book_num=" + book_num + ", book_name=" + book_name + ", book_price=" + book_price
				+ ", category_code=" + category_code + ", category_code_explain=" + category_code_explain
				+ ", book_explain=" + book_explain + ", book_writer=" + book_writer + ", book_score=" + book_score
				+ ", book_sold_count=" + book_sold_count + ", book_image=" + book_image + ", book_stock=" + book_stock
				+ ", book_amount=" + book_amount + "]";
	}
}

package com.sol.vo;

public class TempBuyVo {

	private int book_num;
	private int book_amount;
	private String mem_id;
	public TempBuyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TempBuyVo(int book_num, int book_amount, String mem_id) {
		super();
		this.book_num = book_num;
		this.book_amount = book_amount;
		this.mem_id = mem_id;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getBook_amount() {
		return book_amount;
	}
	public void setBook_amount(int book_amount) {
		this.book_amount = book_amount;
	}
	@Override
	public String toString() {
		return "TempBuyVo [book_num=" + book_num + ", book_amount=" + book_amount + ", mem_id=" + mem_id + "]";
	}
}

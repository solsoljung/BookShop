package com.sol.vo;

public class PagingVo {

	private int start_page;
	private int end_page;
	public PagingVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagingVo(int start_page, int end_page) {
		super();
		this.start_page = start_page;
		this.end_page = end_page;
	}
	public int getStart_page() {
		return start_page;
	}
	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}
	public int getEnd_page() {
		return end_page;
	}
	public void setEnd_page(int end_page) {
		this.end_page = end_page;
	}
	@Override
	public String toString() {
		return "PagingVo [start_page=" + start_page + ", end_page=" + end_page + "]";
	}
	
}

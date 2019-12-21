package com.sol.vo;

public class SearchVo {

	private String searchKeyword;

	public SearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchVo(String searchKeyword) {
		super();
		this.searchKeyword = searchKeyword;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "SearchVo [searchKeyword=" + searchKeyword + "]";
	}
	
	
}

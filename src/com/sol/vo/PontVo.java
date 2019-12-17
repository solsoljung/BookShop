package com.sol.vo;

import java.sql.Timestamp;

public class PontVo {

	private int point_num;
	private String mem_id;
	private Timestamp point_date;
	private int point_score;
	private String point_code;
	private String point_code_explain;
	public PontVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PontVo(int point_num, String mem_id, Timestamp point_date, int point_score, String point_code,
			String point_code_explain) {
		super();
		this.point_num = point_num;
		this.mem_id = mem_id;
		this.point_date = point_date;
		this.point_score = point_score;
		this.point_code = point_code;
		this.point_code_explain = point_code_explain;
	}

	public int getPoint_num() {
		return point_num;
	}
	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Timestamp getPoint_date() {
		return point_date;
	}
	public void setPoint_date(Timestamp point_date) {
		this.point_date = point_date;
	}
	public String getPoint_code() {
		return point_code;
	}
	public void setPoint_code(String point_code) {
		this.point_code = point_code;
	}
	public String getPoint_code_explain() {
		return point_code_explain;
	}
	public void setPoint_code_explain(String point_code_explain) {
		this.point_code_explain = point_code_explain;
	}

	public int getPoint_score() {
		return point_score;
	}

	public void setPoint_score(int point_score) {
		this.point_score = point_score;
	}

	@Override
	public String toString() {
		return "PontVo [point_num=" + point_num + ", mem_id=" + mem_id + ", point_date=" + point_date + ", point_score="
				+ point_score + ", point_code=" + point_code + ", point_code_explain=" + point_code_explain + "]";
	}
}

package com.hn0820.model;

public class Division {
	private int id;
	private String name;
	private String no;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}

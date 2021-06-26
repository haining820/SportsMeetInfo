package com.hn0820.model;

public class Event {
	private int id;
	private String name;
	private String judge;
	private int max_athlete_num;
	private int selected_num = 0;
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
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public int getMax_athlete_num() {
		return max_athlete_num;
	}
	public void setMax_athlete_num(int max_athlete_num) {
		this.max_athlete_num = max_athlete_num;
	}
	public int getSelected_num() {
		return selected_num;
	}
	public void setSelected_num(int selected_num) {
		this.selected_num = selected_num;
	}
	
	
	public String toString(){
		return this.name;
	}//תΪstring
	
	
}

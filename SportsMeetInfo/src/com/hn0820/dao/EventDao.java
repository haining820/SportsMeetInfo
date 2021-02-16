package com.hn0820.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hn0820.model.Division;
import com.hn0820.model.Event;
import com.hn0820.util.StringUtil;

public class EventDao extends BaseDao {
	public boolean addEvent(Event event){
		String sql = "insert into s_event values(null,?,?,?,0)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, event.getName());
			preparedStatement.setString(2, event.getJudge());
			preparedStatement.setInt(3, event.getMax_athlete_num());
			if(preparedStatement.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Event> getEventList(Event event){
		List<Event> retList = new ArrayList<Event>();
		String sqlString = "select * from s_event";
		if(!StringUtil.isEmpty(event.getName())){
			sqlString += " where event_name like '%"+event.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Event eve = new Event();
				eve.setId(executeQuery.getInt("event_id"));
				eve.setName(executeQuery.getString("event_name"));
				eve.setJudge(executeQuery.getString("event_judge"));
				eve.setMax_athlete_num(executeQuery.getInt("event_max_athlete_num"));
				eve.setSelected_num(executeQuery.getInt("event_selected_num"));
				retList.add(eve);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_event where event_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Event eve){
		String sql = "update s_event set event_name=?, event_judge=?, event_max_athlete_num=? where event_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, eve.getName());
			preparedStatement.setString(2, eve.getJudge());
			preparedStatement.setInt(3, eve.getMax_athlete_num());
			preparedStatement.setInt(4, eve.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean selectedEnable(int event_id){//判断可不可以报名
		String sql = "select * from s_event where event_id=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, event_id);
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				int max_student_num = executeQuery.getInt("event_max_athlete_num");
				int selected_num = executeQuery.getInt("event_selected_num");
				if(selected_num >= max_student_num) return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean updateSelectedNum(int event_id,int num){
		String sql = "update s_event set event_selected_num = event_selected_num + ? where event_id = ?";
		if(num < 0){
			sql = "update s_event set event_selected_num = event_selected_num - ? where event_id = ?";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, event_id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	
}

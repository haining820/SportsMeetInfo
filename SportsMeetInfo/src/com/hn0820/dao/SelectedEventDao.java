package com.hn0820.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hn0820.model.SelectedEvent;


public class SelectedEventDao extends BaseDao {
	public boolean addSelectedEvent(SelectedEvent selectedEvent){
		String sql = "insert into s_selectedevent values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, selectedEvent.getAthlete_id());
			preparedStatement.setInt(2, selectedEvent.getEvent_id());
			if(preparedStatement.executeUpdate() > 0)  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateSelectedCourse(SelectedEvent selectedEvent){
		String sql = "update s_selectedevent set selectedEvent_athleteId = ?,selectedEvent_eventId = ? where selectedEvent_id = ?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, selectedEvent.getAthlete_id());
			preparedStatement.setInt(2, selectedEvent.getEvent_id());
			preparedStatement.setInt(3, selectedEvent.getId());
			if(preparedStatement.executeUpdate() > 0)  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<SelectedEvent> getSelectedEventList(SelectedEvent selectedEvent){
		List<SelectedEvent> retList = new ArrayList<SelectedEvent>();
		StringBuffer sqlString = new StringBuffer("select * from s_selectedevent");
		if(selectedEvent.getAthlete_id() != 0){
			sqlString.append(" and selectedEvent_athleteId = "+selectedEvent.getAthlete_id());
		}
		if(selectedEvent.getEvent_id() != 0){
			sqlString.append(" and selectedEvent_eventId ="+selectedEvent.getEvent_id());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				SelectedEvent se = new SelectedEvent();
				se.setId(executeQuery.getInt("selectedEvent_id"));
				se.setAthlete_id(executeQuery.getInt("selectedEvent_athleteId"));
				se.setEvent_id(executeQuery.getInt("selectedEvent_eventId"));
				retList.add(se);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean isSelected(SelectedEvent selectedEvent){
		String sql = "select * from s_selectedevent where selectedEvent_athleteId=? and selectedEvent_eventId = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, selectedEvent.getAthlete_id());
			prst.setInt(2, selectedEvent.getEvent_id());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id){
		String sql = "delete from s_selectedevent where selectedEvent_id=?";
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
}

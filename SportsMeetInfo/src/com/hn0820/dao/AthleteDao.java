package com.hn0820.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hn0820.model.Admin;
import com.hn0820.model.Athlete;
import com.hn0820.model.Division;
import com.hn0820.util.StringUtil;

public class AthleteDao extends BaseDao {
	public boolean addAthlete(Athlete athlete){
		String sql = "insert into s_athlete values(null,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,athlete.getStudentnumber());
			preparedStatement.setString(2, athlete.getName());
			preparedStatement.setInt(3, athlete.getDivisionId());
			preparedStatement.setString(4, athlete.getPassword());
			preparedStatement.setString(5, athlete.getSex());
			if(preparedStatement.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Athlete> getAthleteList(Athlete athlete){
		List<Athlete> retList = new ArrayList<Athlete>();
		StringBuffer sqlString = new StringBuffer("select * from s_athlete");
		if(!StringUtil.isEmpty(athlete.getStudentnumber())){
			sqlString.append(" and athlete_studentnumber like '%"+athlete.getStudentnumber()+"%'");
		}
		if(!StringUtil.isEmpty(athlete.getName())){
			sqlString.append(" and athlete_name like '%"+athlete.getName()+"%'");
		}
		if(athlete.getDivisionId() != 0){
			sqlString.append(" and athlete_divisionId ="+athlete.getDivisionId());
		}

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Athlete ath = new Athlete();
				ath.setId(executeQuery.getInt("athlete_id"));
				ath.setStudentnumber(executeQuery.getString("athlete_studentnumber"));
				ath.setName(executeQuery.getString("athlete_name"));
				ath.setDivisionId(executeQuery.getInt("athlete_divisionId"));
				ath.setPassword(executeQuery.getString("athlete_password"));
				ath.setSex(executeQuery.getString("athlete_sex"));
				retList.add(ath);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean delete(int id){
		String sql = "delete from s_athlete where athlete_id=?";//删除
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
	
	public boolean update(Athlete athlete){
		String sql = "update s_athlete set athlete_studentnumber=?, athlete_name=?, athlete_divisionId=?,athlete_sex=?,athlete_password=? where athlete_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, athlete.getStudentnumber());
			preparedStatement.setString(2, athlete.getName());
			preparedStatement.setInt(3, athlete.getDivisionId());
			preparedStatement.setString(4, athlete.getSex());
			preparedStatement.setString(5, athlete.getPassword());
			preparedStatement.setInt(6, athlete.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String editPassword(Athlete athlete,String newPassword){
		String sql = "select * from s_athlete where athlete_id=? and athlete_password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, athlete.getId());
			prst.setString(2, athlete.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("athlete_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update s_athlete set athlete_password = ? where athlete_id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		return retString;
	}
	
	public Athlete login(Athlete athlete){
		String sql = "select * from s_athlete where athlete_name=? and athlete_password=?";
		Athlete athleteRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, athlete.getName());
			prst.setString(2, athlete.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				athleteRst = new Athlete();
				athleteRst.setStudentnumber(executeQuery.getString("athlete_studentnumber"));
				athleteRst.setId(executeQuery.getInt("athlete_id"));
				athleteRst.setDivisionId(executeQuery.getInt("athlete_divisionId"));
				athleteRst.setName(executeQuery.getString("athlete_name"));
				athleteRst.setPassword(executeQuery.getString("athlete_password"));
				athleteRst.setSex(executeQuery.getString("athlete_sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return athleteRst;
	}
	
}


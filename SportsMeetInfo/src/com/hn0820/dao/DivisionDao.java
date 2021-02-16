package com.hn0820.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hn0820.model.Division;
import com.hn0820.util.StringUtil;


//学院信息与数据库的操作

public class DivisionDao extends BaseDao {
	public boolean addDivision(Division di) {
		String sql = "insert into s_division values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, di.getName());
			preparedStatement.setString(2, di.getNo());
			if(preparedStatement.executeUpdate() > 0)  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Division> getDivisionList(Division division){
		List<Division> retList = new ArrayList<Division>();
		String sqlString = "select * from s_division";
		if(!StringUtil.isEmpty(division.getName())){
			sqlString += " where division_name like '%"+division.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Division dvs = new Division();
				dvs.setId(executeQuery.getInt("division_id"));
				dvs.setName(executeQuery.getString("division_name"));
				dvs.setNo(executeQuery.getString("division_no"));
				retList.add(dvs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_division where division_id=?";//删除
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
	
	public boolean update(Division div){
		String sql = "update s_division set division_name=?, division_no=? where division_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, div.getName());
			preparedStatement.setString(2, div.getNo());
			preparedStatement.setInt(3, div.getId());
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






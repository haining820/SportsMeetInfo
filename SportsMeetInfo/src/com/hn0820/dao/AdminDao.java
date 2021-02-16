package com.hn0820.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hn0820.model.Admin;

public class AdminDao extends BaseDao {
	/**
	 * ����Ա��½
	 */
	public Admin login(Admin admin){
		String sql = "select * from s_admin where admin_name=? and admin_password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);  //��sql��䴫�����ݿ��������
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("admin_id"));
				adminRst.setName(executeQuery.getString("admin_name"));
				adminRst.setPassword(executeQuery.getString("admin_password"));
				adminRst.setCreateDate(executeQuery.getString("admin_createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	}

	public String editPassword(Admin admin,String newPassword){
		String sql = "select * from s_admin where admin_id=? and admin_password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "���������";
				return retString;
			}
			id = executeQuery.getInt("admin_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//��sql��䴫�����ݿ��������
		String retString = "�޸�ʧ��";
		String sqlString = "update s_admin set admin_password = ? where admin_id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "�����޸ĳɹ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��sql��䴫�����ݿ��������
		return retString;
	}
}

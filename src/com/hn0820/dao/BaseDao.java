package com.hn0820.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hn0820.util.DbUtil;

/**
 * 
 * @author llq
 *���������ݿ����Ӷ���������Ŀ�����ݿ�򽻵�������һ������.
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

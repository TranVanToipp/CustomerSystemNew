/**
 * @(#)T001Dao.java 01-00 2021/07/16
 *
 * Copyright(C) 2021 by FUJINET CO., LTD.
 *
 * Last_Update 2021/07/16
 * Version 1.00.
 */
package fjs.cs.dao;
/**
 * T001Dao
 * 
 * @version 1.00
 * @since  1.00
 * @author Long-PH
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fjs.cs.dto.T001Dto;

public class T001Dao {
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://TOI-TV-TTV-VM\\SQLEXPRESS:1433;databaseName=CustomerSystem";
			connection = DriverManager.getConnection(connectionURL,"sa", "TranVanToi234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public T001Dto CheckLogin(String user, String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select COUNT(*) as CNT from MSTUSER where DELETE_YMD is null and USERID =? and PASSWORD =?";
			conn = new T001Dao().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
		        int count = rs.getInt("CNT");
		        if (count == 1) {
		            T001Dto a = new T001Dto(user, pass);
		            return a;
		        } else {
		            return null;
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

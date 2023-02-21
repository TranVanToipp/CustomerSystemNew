package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

import entyti.Account;

public class LoginDao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String User = "root";
			String Pass = "";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customsystem", User, Pass);
		}catch(Exception e) {
			System.out.print(e);
		}
		return con;
	}
	
	
	public Account CheckLogin(String user, String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT count(*) as CNT FROM mstuser WHERE DELETE_YMD is null and USERID = ? AND PASSWORD = ?";
			conn = new LoginDao().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
		        int count = rs.getInt("CNT");
		        if (count == 1) {
		            Account a = new Account(user, pass);
		            return a;
		        } else {
		            // Nếu số lượng bản ghi trả về không phải là 1, thì không đăng nhập thành công
		            return null;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}


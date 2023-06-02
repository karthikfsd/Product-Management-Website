package dao;

import java.sql.*;


import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {
	
	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection Obj
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from login_info where user_name = '"+userDetails.getUserName()+"' and password = '"+userDetails.getPassword()+"'");
			
			while(rs.next()) {
				validStatus=true;
			}
			
			rs.close();
			st.close();
			DBUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return validStatus;
	}
	
	public static int registerUser(LoginInfo registerDetails) {
		int status =0;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO login_info values(?,?)");
			ps.setString(1, registerDetails.getUserName());
			ps.setString(2, registerDetails.getPassword());
			status = ps.executeUpdate();
			ps.close();
			DBUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
}

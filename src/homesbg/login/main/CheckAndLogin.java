package homesbg.login.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckAndLogin {
	private String email;
	private String password;

	
	CheckAndLogin(String email, String password){
		this.setEmail(email);
		this.setPassword(password);
	}


	
	private void setEmail(String email){
		if(email == null || !email.contains("@") || !email.contains(".") || email.trim().length() <= 6){
			throw new IllegalArgumentException("Illegal email input.");
		}
		this.email = email;
	}


	private void setPassword(String password) {
		if(password == null || password.trim().length() < 6){
			throw new IllegalArgumentException("Illegal password input.");
		}
		this.password = password;
	}
	
	public boolean isCorrect() throws ClassNotFoundException, SQLException{
		
		Connection conn = getMysqlConnection();
		ResultSet rs = getConnection(conn);
		
		while(rs.next()){
			if(rs.getString(2).equals(email) && rs.getString(3).equals(password)){
				return true;
			}
		}
		
		return false;
	}

	private ResultSet getConnection(Connection conn) throws ClassNotFoundException, SQLException {
		return getConnection(conn, "select * from customerdata");
	}

	private ResultSet getConnection(Connection conn, String sql) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Statement st = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);
		return st.executeQuery(sql);
	}

	private Connection getMysqlConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/homesbg","homesbg","homesbg666666");
	}
	
}

package homesbg.registration.mysqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import homesbg.registration.companyData.CompanyData;
import homesbg.registration.contactData.Agency;
import homesbg.registration.contactData.ContactData;
import homesbg.registration.customerData.CustomerData;
import homesbg.registration.pageData.Page;

public class MySqlConnection implements IConnection {
	private String email;
	
	public MySqlConnection(String email){
		this.email = email;
		
	}
	
	public boolean isEmailFree() throws SQLException, ClassNotFoundException{
		Connection conn = getMysqlConnection();
		ResultSet rs = getConnection(conn);

		while (rs.next()) {
			if (rs.getString(2).equals(email)) {
				return false;
			}
		}
		return true;
	}

	private ResultSet getConnection(Connection conn) throws ClassNotFoundException, SQLException {
		return getConnection(conn,"select * from customerdata");
	}

	private ResultSet getConnection(Connection conn, String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Statement st = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);
		return st.executeQuery(query);
	}


	@Override
	public void addCompanyData(CompanyData companyD) {
		try {
			Connection conn = getMysqlConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("insert into companydata values(null,'" + companyD.getType() 
				+ "','" + companyD.getName() + "','" + companyD.getAddress() + "','" 
				+ companyD.getMOL() + "','" + companyD.getEIK() + "','" 
				+ companyD.getAdministrativePersonNames() + "','" + companyD.getDuty() + "','"  
				+ companyD.getNumber() + "','" + companyD.getEmail() + "')");
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addContactData(ContactData contactD) {
		try {
			Connection conn = getMysqlConnection();
			Statement st = conn.createStatement();
			if(contactD instanceof Agency){
				st.executeUpdate("insert into contactdata values(null,'" + contactD.getCountry() + "','"
						+ contactD.getArea() + "','" + contactD.getLivingArea() + "','" 
						+ contactD.getAddress() + "','" + contactD.getNumber() + "','" 
						+ contactD.getWebSiteLink() + "','" + ((Agency) contactD).getAgencyName() +  "')");
			}
			else{
				st.executeUpdate("insert into contactdata values(null,'" + contactD.getCountry() + "','"
						+ contactD.getArea() + "','" + contactD.getLivingArea() + "','" 
						+ contactD.getAddress() + "','" + contactD.getNumber() + "','" 
						+ contactD.getWebSiteLink() + "',' ')");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPageName(Page page) {
		try {
			Connection conn = getMysqlConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("insert into pagename values(null,'" + page.getName() + "')");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomerData(CustomerData customerD) {
		try {
			Connection conn = getMysqlConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("insert into customerdata values(null,'" + customerD.getEmail() + "','" 
					+ customerD.getPassword() + "','" + customerD.getfName() + "','" 
					+ customerD.getlName() + "','" + customerD.getDuty() + "','" 
					+ customerD.getNumber() + "','" + customerD.getSkype() + "','" 
					+ customerD.getAdditionalInfo() + "','" + customerD.getAccountUsage() + "')");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private Connection getMysqlConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/homesbg" , "homesbg","homesbg666666");
	}
	
}

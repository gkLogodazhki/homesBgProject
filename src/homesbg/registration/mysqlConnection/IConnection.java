package homesbg.registration.mysqlConnection;

import java.sql.SQLException;

import homesbg.registration.companyData.CompanyData;
import homesbg.registration.contactData.ContactData;
import homesbg.registration.customerData.CustomerData;
import homesbg.registration.pageData.Page;

public interface IConnection {
	boolean isEmailFree() throws SQLException, ClassNotFoundException;
	void addCompanyData(CompanyData companyD);
	void addContactData(ContactData contactD);
	void addPageName(Page page);
	void addCustomerData(CustomerData customerD);
}

package homesbg.registration.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homesbg.registration.companyData.CompanyData;
import homesbg.registration.companyData.Type;
import homesbg.registration.contactData.Agency;
import homesbg.registration.contactData.Construction;
import homesbg.registration.contactData.ContactData;
import homesbg.registration.customerData.CustomerData;
import homesbg.registration.mysqlConnection.IConnection;
import homesbg.registration.mysqlConnection.MySqlConnection;
import homesbg.registration.pageData.Page;

@WebServlet("/Registration")
public class RegisterAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterAgency() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		try{
			String pageType = request.getParameter("pageType");
			Type type = Type.Строителна_фирма;
			if(pageType.equals("1")){
				type = Type.Агенция_за_недвижими_имоти;
			}
			
			// company data 
			String companyName = request.getParameter("companyName");
			String companyAddress = request.getParameter("companyAddress");
			String MOL = request.getParameter("MOL");
			String EIK = request.getParameter("EIK");
			String adContact = request.getParameter("administrativeContact");
			String companyDuty = request.getParameter("companyDuty");
			String companyPhone = request.getParameter("phoneNumber");
			String adEmail = request.getParameter("administrativeContactEmail");
			CompanyData company = new CompanyData(type, companyName, companyAddress, MOL, EIK, adContact, companyDuty,
					companyPhone, adEmail);

			// contactData
			String country = request.getParameter("contactCountry");
			String area = request.getParameter("contactArea");
			String livingArea = request.getParameter("contactLivingArea");
			String contactAddress = request.getParameter("contactAddress");
			String contactPhone = request.getParameter("contactPhone");
			String website = request.getParameter("contactWebSite");
			ContactData contactData = null;
			if(pageType.equals("1")){
				String agencyName = request.getParameter("agencyName");
				contactData = new Agency(agencyName, country, area
						, livingArea, contactAddress, contactPhone, website);
			}
			else{
				contactData = new Construction(country, area
						, livingArea, contactAddress, contactPhone, website);
			}

			// pagename
			String pageName = request.getParameter("pageName");
			Page page = new Page(pageName);

			// customer data
			String customerEmail = request.getParameter("customerEmail");
			String password = request.getParameter("password");
			String repeatedPassword = request.getParameter("repeatedPassword");
			String fName = request.getParameter("fName");
			String lName = request.getParameter("lName");
			String customerDuty = request.getParameter("customerDuty");
			String customerPhone = request.getParameter("customerPhone");
			String skype = request.getParameter("skype");
			String additionalInfo = request.getParameter("additionalInfo");
			String usage = request.getParameter("accountUsage");
			CustomerData customerData = new CustomerData(customerEmail, password, repeatedPassword, fName, lName,
					customerDuty, customerPhone, skype, additionalInfo, usage);
			
			IConnection con = new MySqlConnection(customerEmail);
			
			if(con.isEmailFree()){
				con.addCustomerData(customerData);
				con.addPageName(page);
				con.addContactData(contactData);
				con.addCompanyData(company);
				
				response.sendRedirect("Registration/RegistrationAgency.jsp");
				
			}
			else{
				System.out.println("The email is occupied");
				response.sendRedirect("Registration/RegistrationAgency.jsp");
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			response.sendRedirect("Registration/RegistrationAgency.jsp");
		}
	}

}

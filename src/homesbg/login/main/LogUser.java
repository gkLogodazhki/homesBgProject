package homesbg.login.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogUser")
public class LogUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			CheckAndLogin cal = new CheckAndLogin(email,password);
			if(cal.isCorrect()){
				System.out.println("Login");
				
			}
			else{
				System.out.println("No such user");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			response.sendRedirect("Login/LoginPage.jsp");
		}
		
	}

}

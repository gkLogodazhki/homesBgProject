package homesbg.servlets;

import homesbg.dbCon.DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/AdAddServlet")
public class addAdServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            // get ad info from jsp
            String tempAdType = request.getParameter("adType");

            // get the adType id from database
            int adType = DatabaseAccess.selectAdType(tempAdType);
            // get the estate
            int estateType = DatabaseAccess.selectEstateType(request.getParameter("estateType"));
            int price = Integer.parseInt(request.getParameter("price"));
            if (price < 0){
                throw new ServletException("the price can't be negative");
            }
            int area = Integer.parseInt(request.getParameter("area"));
            if (area < 0){
                throw new ServletException("the area can't be negative");
            }

            // throws nullPointerException if procuce_year is not a valid LocalDate
            LocalDate produce_date = LocalDate.parse(request.getParameter("produce_year"));

            String estate_kind = request.getParameter("estate_kind");
            String furnishing = request.getParameter("firnishing");
            int floor = Integer.parseInt(request.getParameter("floor"));
            if (floor < 0){
                throw new ServletException("the floor can't be negative");
            }

            int total_floors = Integer.parseInt(request.getParameter("total_floors"));
            if (total_floors < 0){
                throw new ServletException("the total floor can't be negative");
            }
            if (floor > total_floors){
                throw new ServletException("the total floors must be greater than tha floor");
            }

            // get place info from jsp
            int city_id = DatabaseAccess.insertToCity(request.getParameter("city"));
            String neighboorhood = request.getParameter("neighboorhood");
            if (!"".equals(neighboorhood)){
                throw new ServletException("you should input a neighboorhood");
            }
            String address = request.getParameter("address");
            if (!"".equals(address)){
                throw new ServletException("you should input an address");
            }
            // insert the place into databace and get the place_id
            int place_id = DatabaseAccess.insertIntoPlace(city_id,neighboorhood,address);

            // if the ad is of type sell there is no info for the following Strings
            // else get info for them from jsp
            String isPetsAllowed = null, hasShortLoan = null;
            if (!tempAdType.equals("sale")){
                isPetsAllowed = request.getParameter("isPetAllowrd");
                hasShortLoan = request.getParameter("hasShortLoan");
                DatabaseAccess.insertIntoAd(adType,estateType,price,area,produce_date,estate_kind,furnishing,floor,total_floors,place_id, isPetsAllowed, hasShortLoan);
            }

            // insert the ad into database
            DatabaseAccess.insertIntoAd(adType,estateType,price,area,produce_date,estate_kind,furnishing,floor,total_floors,place_id, isPetsAllowed, hasShortLoan);


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
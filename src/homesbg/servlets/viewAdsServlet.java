package homesbg.servlets;

import homesbg.dbCon.DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/viewAdsServlet")
public class viewAdsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{


            // get info from jsp
            String tempAdType = request.getParameter("adType");

            int adType = DatabaseAccess.selectAdType(tempAdType);

            int minPrice = Integer.parseInt(request.getParameter("minPrice"));
            int maxPrice = Integer.parseInt(request.getParameter("maxPrice"));

            if (minPrice < 0 || maxPrice < 0){
                throw new ServletException("you can't input a negative price");
            }
            if (minPrice > maxPrice){
                throw new ServletException("you can't input min price which is greater than max price");
            }

            int minArea = Integer.parseInt(request.getParameter("minArea"));
            int maxArea = Integer.parseInt(request.getParameter("minArea"));

            if (minArea < 0 || maxArea < 0){
                throw new ServletException("you can't input a negative area");
            }
            if (minArea > maxArea){
                throw new ServletException("you can't input min price which is greater than max area");
            }

            String[] estate_types = request.getParameterValues("estate_types[]");
            String[] extras = request.getParameterValues("extras[]");

            String produce_year = request.getParameter("produce_year");
            String furnishing = request.getParameter("furnishing");
            String otoplenie = request.getParameter("otoplenie");


            // get the result set from query
            ResultSet resultSet = DatabaseAccess.viewFromAdBuilding(adType,estate_types,minPrice,maxPrice,minArea,maxArea,extras,produce_year, furnishing, otoplenie);

            // TODO output the resultSet into jsp

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
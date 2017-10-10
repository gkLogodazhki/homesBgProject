package homesbg.dbCon;

import java.time.LocalDate;
import java.sql.*;

public class DatabaseAccess{

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/homes";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "vegas";

    private static DatabaseAccess instance = new DatabaseAccess();
    private static Connection con;

    public static synchronized DatabaseAccess getInstance() {
        return (instance == null) ? new DatabaseAccess() : instance;
    }

    private DatabaseAccess(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int selectAdType(String type){
        String sql = "SELECT id From ad_type WHERE ad_type Like ?";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setString(1, type);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int selectEstateType(String type){
        String sql = "SELECT id From estate_type WHERE estate_type Like ?";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setString(1, type);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void insertIntoAd(int adType, int estaetType, int price, int area, LocalDate produce_date, String estate_kind, String furnishing, int floor, int total_floors, int place_id, String isPetAllowed, String hasShortLoan) {
        String sql = "INSERT INTO ad(ad_type_id, estate_type_id,area,produce_date,estate_kind,furnishing,floor,total_floors,place_id) VALUES (?, ?, ?, ?, ? , ? , ? , ? , ?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setInt(1, adType);
            statement.setInt(2, estaetType);
            statement.setInt(3, price);
            statement.setInt(4, area);
            statement.setDate(5, Date.valueOf(produce_date));
            statement.setString(6, estate_kind);
            statement.setString(7, furnishing);
            statement.setInt(8, floor);
            statement.setInt(9, total_floors);
            statement.setInt(9, place_id);
            statement.setString(10, isPetAllowed);
            statement.setString(11, hasShortLoan);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int insertIntoPlace(int city_id, String neighboorhood, String address) {
        String sql = "INSERT INTO ad(city_id, neighboorhood,address) VALUES (?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setInt(1, city_id);
            statement.setString(2, neighboorhood);
            statement.setString(3, address);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "SELECT last_insert_id() id FROM place";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int insertToCity(String city) {
        String sql = "INSERT INTO city(name) VALUES (?)";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setString(1, city);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "SELECT id FROM city WHERE name LIKE ? ";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    public static ResultSet viewFromAdBuilding(int adType, String[] estate_types, int minPrice, int maxPrice, int minArea, int maxArea, String[] extras, String produce_year, String furnishing, String otoplenie) {
        String sql = "SELECT * FROM ad WHERE ad_type LIKE ? AND estate_type_id is in ? AND (price between ? AND ?) AND (area between ? and ?) AND (produce_year LIKE ?) AND (furnishing LIKE ?)";
        try (PreparedStatement statement = con.prepareStatement(sql);){
            statement.setInt(1, adType);
//            statement.setString(2, estate_types);
            statement.setInt(3, minPrice);
            statement.setInt(4, maxPrice);
            statement.setInt(5, minArea);
            statement.setInt(6, maxArea);
            statement.setDate(7, Date.valueOf(produce_year));
            statement.setString(8, furnishing);

            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
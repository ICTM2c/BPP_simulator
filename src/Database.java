import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection connection;

    public Order fetchOrder(int OrderId) { //Beide moeten worden gereworked
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazijnrobot","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } try {
            PreparedStatement stmt = connection.prepareStatement("SELECT `OrderId` FROM ORDER WHERE OrderId = ?");
            stmt.setInt(1,OrderId);
            ResultSet rs = stmt.executeQuery();
            String res = rs.toString();
            int resu = Integer.parseInt(res);
            Order result = new Order(resu);
            return result;
        } catch (Exception e) {
            return  null;
        }
    }

    public List<Order> fetchOrderOfCustomer(int customerID) {
        List<Order> result = new ArrayList<Order>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazijnrobot","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } try {
            PreparedStatement stmt = connection.prepareStatement("SELECT `OrderId` FROM Order WHERE CustomerID IS " + customerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String res = rs.getString(1);

//
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}

package TSPSimulator.Database;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private Connection connection;

    public MysqlxCrud.Order fetchOrder(int OrderId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazijnrobot","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } try {
            PreparedStatement stmt = connection.prepareStatement("SELECT `OrderId` FROM ORDER WHERE OrderId IS" + OrderId);
            ResultSet rs = stmt.executeQuery();
            



        } catch (Exception e) {
            return  null;
        }
        return null;
    }

    public List<MysqlxCrud.Order> fetchOrderOfCustomer(int customerID) {
//        try {
//            PreparedStatement stmt = conn.prepareStatement("SELECT p.*, s.* FROM Product p\n" +
//                    "INNER JOIN product_order o ON p.productid = o.orderid\n" +
//                    "INNER JOIN shelve s ON o.shelveid = s.ShelveId\n" +
//                    "WHERE o.orderid = ?");
//            stmt.setInt(1, order);
//            ResultSet rs = stmt.executeQuery();
//            List<TSPSimulator.Models.Product> res = new ArrayList<>();
//            while (rs.next()) {
//                res.add(TSPSimulator.Models.Product.FromResultSet(rs));
//            }
//            return res;
//        }
//        catch (Exception e) {
//            return null;
//        }
        return null;
    }

    private void Conn(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

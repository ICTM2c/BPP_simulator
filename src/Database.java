import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection connection;

    public Order fetchOrder(int OrderId) {
        Order result = new Order(OrderId);

        try {
            Class.forName("com.mysql.jdbc.Driver"); //Connectie met database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazijnrobot","root","");
        } catch (SQLException e) { //Als er geen connectie kan worden gemaakt met de database
            e.printStackTrace();
            System.out.println("Connectie Error...");
        } catch (ClassNotFoundException e) { //Als class niet gevonden kan worden
            e.printStackTrace();
            System.out.println("Class Error...");
        } try {
            PreparedStatement stmt = connection.prepareStatement("SELECT p.* FROM Product p\n" +
                    "INNER JOIN product_order o ON p.productid = o.orderid\n" +
                    "WHERE o.orderid = ?"); //Query werkt
            stmt.setInt(1,OrderId); //vormt eerste vraagteken om in orderId
            ResultSet rs = stmt.executeQuery(); //Uitvoeren query
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getInt(2));
                result.addProduct(product);
            }
            return result;  //return result
        } catch (Exception e) {
            System.out.println("Query Error..."); //Als er een fout is in het bewerken van de query
            return  null;
        }
    }

    public List<Order> fetchOrderOfCustomer(int customerID) { //BORKED = now worked
        List<Order> result = new ArrayList<>(); // return array met orders

        try {
            Class.forName("com.mysql.jdbc.Driver"); //Connectie met database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazijnrobot","root","");
        } catch (SQLException e) { //Als de verbinding met sql niet kan worden gemaakt
            System.out.println("Connectie Error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) { //Als de klasse niet wordt gevonden
            System.out.println("Class Error...");
            e.printStackTrace();
        } try {
            PreparedStatement stmt = connection.prepareStatement("SELECT O.`OrderId`,P.`ProductId` FROM `Order` AS O INNER JOIN `Product_Order` AS P ON O.OrderId = P.OrderId WHERE CustomerID = ?");
            stmt.setInt(1,customerID); //zet ? om in customerID wat meegegeven wordt
            ResultSet rs = stmt.executeQuery(); //Uitvoeren querry

            while (rs.next()) {
                int orderId = rs.getInt(1); //OrderID ophalen uit querry
                int productId = rs.getInt(2); //ProductID ophalen uit querry
                Order orderOfProduct = findOrderInList(result, orderId); //Maak nieuwe order aan en find de order in de list
                orderOfProduct.addProduct(new Product(productId)); //voeg nieuw product toe aan
            }
            return result; //return result list
        } catch (Exception e) { //Als er iets mis mocht gaan in de try
            System.out.println("Query Error");
            return null;
        }
    }

    public Order findOrderInList(List<Order> result, int orderId) {
        for (int i = 0; i < result.size(); i++) { //Loopt array result door om te vergelijken of er al een order bestaat met hetzelfde orderID
            if (result.get(i).getOrderId() == orderId) { //Vergelijking
                return result.get(i);
            }
        }
        Order order = new Order(orderId); //Maak nieuwe order aan met id uit de querry
        result.add(order); //Order wordt toegevoegd aan de result list
        return order;
    }

}


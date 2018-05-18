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
            e.printStackTrace();
        } catch (ClassNotFoundException e) { //Als de klasse niet wordt gevonden
            e.printStackTrace();
        } try {
            PreparedStatement stmt = connection.prepareStatement("SELECT O.`OrderId`,P.`ProductId` FROM `Order` AS O WHERE CustomerID = ? INNER JOIN `Product_Order` AS P ON `Order`.OrderId = `Product_Order`.OrderId");
            ResultSet rs = stmt.executeQuery(); //Uitvoeren querry
            stmt.setInt(1,customerID); //zet ? om in customerID wat meegegeven wordt
            while (rs.next()) {
                int res = rs.getInt(1); //OrderID ophalen uit querry
                int res2 = rs.getInt(2); //ProductID ophalen uit querry
                for (int i = 0; i < result.size(); i++) { //Loopt array result door om te vergelijken of er al een order bestaat met hetzelfde orderID
                    if (result.get(i).getOrderId() == res) { //Vergelijking
                        Product product1 = new Product(res2); //Nieuw Product om toe te voegen aan de order zijn product list
                        result.get(i).addProduct(product1); //Toevoegen aan product list
                    } else { //Als het orderId niet overeen komt
                        Order order = new Order(res); //Maak nieuwe order aan met id uit de querry
                        Product product = new Product(res2); //Nieuw product met id uit querry
                        order.addProduct(product); //Product wordt toegevoegd aan de net gemaakte order
                        result.add(order); //Order wordt toegevoegd aan de result list
                    }
                }
            }
            return result; //return result list
        } catch (Exception e) { //Als er iets mis mocht gaan in de try
            return null;
        }
    }

}

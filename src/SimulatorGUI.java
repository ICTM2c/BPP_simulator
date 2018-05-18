import java.util.ArrayList;
import java.util.List;

public class SimulatorGUI {

    public static void main(String[] args) {
        Database database = new Database();
        Order order = new Order();
        order = database.fetchOrder(1);
        order.printOrder();

        List<Order> orders = database.fetchOrderOfCustomer(1);
        for (int i = 0; i < orders.size() ; i++) {
            orders.get(i).printOrder();
            System.out.println("\r\n");
        }
    }
}

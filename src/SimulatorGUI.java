
public class SimulatorGUI {

    public static void main(String[] args) {
        Database database = new Database();
        Order order = new Order();
        order = database.fetchOrder(1);
        order.printOrder();
    }
}

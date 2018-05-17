import java.util.List;

public class Order {

    private int OrderId;
    private List<Product> products;

    public Order(int orderId) {
        OrderId = orderId;
    }

    public Order(int orderId, List<Product> Products) {
        OrderId = orderId;
        Products = products;
    }

    public Order() {
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct (Product product) { //Functie voor toevoegen van producten aan de product list
        products.add(product);
    }

    public void printOrderId() {  //Test om orderID uitteprinten
        System.out.println(OrderId);
    }

    public void CreateDeliveryNote() {
        //Moet nog worden gemaakt wanneer de rest werkt
    }
}

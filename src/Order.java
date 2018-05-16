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

    public void CreateDeliveryNote() {

    }
}

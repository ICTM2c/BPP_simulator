import java.util.List;

public class Box {

    private List<Product> Products;
    private int Capacity = 50;

    public Box() {
    }

    public Box(int capacity) {
        Capacity = capacity;
    }

    public int totalUsed() {
        int counter = 0;
        for (int i = 0; i < Products.size() ; i++) {
            counter = counter + Products.get(i).getSize();
        }
        return counter;
    }

    public void addProduct(Product product) { //Voegt een enkel product toe aan list
        Products.add(product);
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}

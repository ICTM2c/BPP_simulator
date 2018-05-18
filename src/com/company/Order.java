package com.company;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int OrderId;
    private List<Product> products;

    public Order(int orderId) {
        OrderId = orderId;
        products = new ArrayList<>();
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

    public void printOrder() {  //Test om orderID uit te printen
        int counter = 1;
        System.out.println("OrderID: "+ OrderId);
        System.out.println("Lijst met producten");
        for (int i = 0; i < products.size() ; i++) {
            System.out.println("Product" + counter + " ProductID: " + products.get(i).getProductId() + " Size: " + products.get(i).getSize());
            counter++;
        }
    }

    public void CreateDeliveryNote() {
        //Moet nog worden gemaakt wanneer de rest werkt
    }
}

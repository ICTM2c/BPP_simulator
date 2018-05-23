package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 0;
    private int OrderId = orderCounter++;
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

    public void addProduct(Product product) { //Functie voor toevoegen van producten aan de product list
        products.add(product);
    }

    public void CreateDeliveryNote(List<Box> boxList, int orderId) { //HTML print methode
        String file = "order_";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file + orderId + ".html"));
            bw.write("<html><head><title>Order" + orderId+ "</title></head><header><h1>Order " + orderId + "</h1></header><body><p>");
            for (Box box : boxList) {

                bw.write("<header><h2>Box " + box.getBoxId() + "</h2></header><br><table><tr><th>Product ID</th><th>Size</th></tr>");
                for (Product product : box.getProducts()) {
                    bw.write("<tr><td>" + product.getProductId() + "</td><td>" + product.getSize() + "</td><tr>");
                }
                bw.write("<table></p></body></html>");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

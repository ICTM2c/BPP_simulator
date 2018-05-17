package com.company;
public class Product {

    private int ProductId;
    private String Name;
    private int Size;

    public Product(int size) {
        Size = size;
    }

    public Product() {
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

}

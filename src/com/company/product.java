package com.company;
class Product {

    private int ProductId;
    private String Name;
    private int Size;

    public Product(int productId, int size) {
        ProductId = productId;
        Size = size;
    }

    public Product() {
    }

    public Product(int capacity) {
        Size = capacity;
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

package com.company;
class Product implements Comparable<Product> {
    private static int s_productCounter = 0;
    private int ProductId = s_productCounter++;
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

    @Override
    public String toString() {
        return "ProductId " + getProductId() + ", Size: " + getSize();
    }

    @Override
    public int compareTo(Product o) {
        return o.getSize() - getSize();
    }
}

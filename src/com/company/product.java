package com.company;

public class product {
    private int productId;
    private int productGrootte;


    public product(int productId, int productGrootte){
        this.productId = productId;
        this.productGrootte = productGrootte;
    }

    public void setProductGrootte(int productGrootte) {
        this.productGrootte = productGrootte;
    }


    public int getProductId() {
        return productId;
    }

    public int getProductGrootte() {
        return productGrootte;
    }
    public String toString(){
        return "Product " + getProductId() + " heeft een grootte van " + getProductGrootte();
    }

}

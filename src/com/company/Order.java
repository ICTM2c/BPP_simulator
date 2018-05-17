package com.company;
import java.util.List;

public class Order {

    private int OrderId;
    private List<Box> Boxes;

    public Order(int orderId) {
        OrderId = orderId;
    }

    public Order(int orderId, List<Box> boxes) {
        OrderId = orderId;
        Boxes = boxes;
    }

    public Order() {
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public List<Box> getBoxes() {
        return Boxes;
    }

    public void setBoxes(List<Box> boxes) {
        Boxes = boxes;
    }

    public void CreateDeliveryNote() {

    }
}

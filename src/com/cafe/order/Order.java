package com.cafe.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 1;
    private final int orderNo;
    private Order.PickUp pickUp;
    private final List<OrderItem> items = new ArrayList<>();
    private boolean completedFlag;

    public Order() {
        this.orderNo = orderCounter++;
        completedFlag = false;
    }

    public void completed() {
        this.pickUp.handle(this);
        completedFlag = true;
        orderCounter--;
    }

    public boolean isCompleted() {
        return completedFlag;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setPickUp(PickUp pickUp) {
        this.pickUp = pickUp;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public interface PickUp {
        public abstract void handle(Order o);
    }

    @Override
    public String toString() {
        return "주문번호: " + orderNo + " - " + items;
    }
}
package com.cafe.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Iterator<Order> {
    private List<Order> orders = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
        return currentIndex < orders.size();
    }

    @Override
    public Order next() {
        return orders.get(currentIndex++);
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        StringBuilder ordersOutput = new StringBuilder("---주문 관리자 화면---\n");
        ordersOutput.append("현재 주문수는 총 ").append(orders.size() - currentIndex).append(" 입니다.\n\n");
        ordersOutput.append("< 주문 내역 >\n");
        for (Order order: orders) {
            if (!order.isCompleted()) {
                ordersOutput.append(order).append("\n");
            }
        }
        return ordersOutput.toString();
    }
}
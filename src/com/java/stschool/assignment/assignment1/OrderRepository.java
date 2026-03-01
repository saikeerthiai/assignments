package com.java.stschool.assignment.assignment1;

import java.util.HashSet;
import java.util.Iterator;

public class OrderRepository {

    HashSet<Order> orders;

    public OrderRepository() {
        orders = new HashSet<>();
    }

    //create new order
    Order save(Order order) {
        orders.add(order);
        return order;
    }

    //read (get all order)
    HashSet<Order> getAll() {
        return orders;

    }

    //get order by id
    Order getById(String id) {
        System.out.println("id: " + id);
        Order orderById = null;
        for (Order order : orders) {
            if (order.getId().equals(id))
                orderById = order;
        }
        return orderById;


    }

    //update order details
    Order update(Order order) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order next = iterator.next();
            if (next.getId().equals(order.getId())) {
                iterator.remove();
                break;
            }
        }
        orders.add(order);
        return order;

    }

    //delete by id
    void delete(String id) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order next = iterator.next();
            if (next.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}

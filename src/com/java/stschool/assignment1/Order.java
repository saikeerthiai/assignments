package com.java.stschool.assignment1;

import java.util.HashSet;
import java.util.Objects;

public class Order {
    private String id;
    private String customerName;
    private HashSet<Product> products;
    private String status;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public void setProducts(HashSet<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(customerName, order.customerName) && Objects.equals(products, order.products) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, products, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", products=" + products +
                ", status='" + status + '\'' +
                '}';
    }
}

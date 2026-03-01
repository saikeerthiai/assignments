package com.java.stschool.assignment.assignment2;

public class Product implements Comparable<Product>{
    private String id;
    private String name;
    private double maxRetailPrice;
    private float  discountPercentage;

    public Product() {
    }

    public Product(String id, String name, double maxRetailPrice, float discountPercentage) {
        this.id = id;
        this.name = name;
        this.maxRetailPrice = maxRetailPrice;
        this.discountPercentage = discountPercentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(double maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", maxRetailPrice=" + maxRetailPrice +
                ", discountPercentage=" + discountPercentage +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return Double.compare(product.getMaxRetailPrice(),this.getMaxRetailPrice());
    }
}


package com.java.stschool.assignment1;

import java.util.HashSet;
import java.util.Iterator;

public class ProductService {
    private HashSet<Product> products;

    public ProductService() {
        this.products = new HashSet<>();
    }

    //methides
    HashSet<Product> getProducts(String[] productsData){


        //step1: split productdata
        for(String productData : productsData){
            //System.out.println(productData);
            String[] split = productData.split(",");
            Product product = new Product();
            product.setId(split[0]);
            product.setName(split[1]);
            product.setMaxRetailPrice(Double.parseDouble(split[2]));
            product.setDiscountPercentage(Float.parseFloat(split[3]));
            products.add(product);


        }
        return products;


    }
    public double calculateFinalPrice(Product product){
        return  product.getMaxRetailPrice() - (product.getMaxRetailPrice() * product.getDiscountPercentage() / 100);

    }
    public void displayProductDetials(Product product){
        double finalPrice = calculateFinalPrice(product);
        System.out.println("id: "+product.getId());
        System.out.println("Product Name: " + product.getName());
        System.out.println("MRP: " + product.getMaxRetailPrice());
        System.out.println("Discount: " + product.getDiscountPercentage() );
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------------");
    }
    HashSet<Product> getProductsById(String[] ids){
        HashSet<Product> productsById = new HashSet<>();
        for(String id : ids){
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()){
                Product product = iterator.next();
                if(product.getId().equals(id))
                    productsById.add(product);

            }
        }
        return productsById;
    }
}

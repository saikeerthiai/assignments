package com.java.stschool.assignment.assignment2;

import java.util.ArrayList;

public class ProductTest {
    public static void main(String[] args) {
        String[] data = {
                "p-101,Lenovo Laptop,58999.00,10.5",
                "p-102,Dell Inspiron,1554999.00,8.0",
                "p-103,HP Pavilion,1462999.00,12.0",
                "p-104,Apple iPhone,1479999.00,5.0",
                "p-105,Samsung Galaxy,74999.00,7.5",
                "p-101,Lenovo Laptop,58999.00,10.5",

        };
        ProductRepository productRepository = new ProductRepository();
        ArrayList<Product> products = productRepository.loadProducts(data);

        System.out.println(products);
        System.out.println("==========size==============");
        System.out.println(products.size());


        //save
        Product product1 = new Product();
        product1.setId("106");
        product1.setName("HP");
        product1.setMaxRetailPrice(657832.0);
        product1.setDiscountPercentage(10.0F);

        Product save = productRepository.save(product1);
        System.out.println("Product: " + save);
        System.out.println("==========create===============");
        System.out.println(products);
        //System.out.println(products);
        System.out.println("==========size==============");
        System.out.println(products.size());


        // get by id
        System.out.println("======GET BY ID======");
        Product productById = productRepository.getProductById("p-103");
        System.out.println(productById);


        //uptade
        System.out.println("==============UPDATED BY ID=================");
        Product productToBeUpdated = new Product();
        productToBeUpdated.setId("p-104");
        productToBeUpdated.setName("Asus");
        productToBeUpdated.setMaxRetailPrice(Double.parseDouble("45000.00"));
        productToBeUpdated.setDiscountPercentage(Float.parseFloat("10.0"));

        productRepository.update("p-104", productToBeUpdated);
        //productRepository.update();
//        for (Product p : products) {
//            System.out.println(p);
//        }
         //System.out.println(productToBeUpdated);
         System.out.println(products);


        //delete
        System.out.println("====Delete By Id====");
        Product deleteById = new Product();
        productRepository.deleteById("p-105");
        System.out.println(products);
        //  productRepository.displayAllProducts(product1);

        //System.out.println(productRepository.deleteById("p-105"));

        System.out.println("Deleted successfully");
        //System.out.println(products);
//        for (Product p : products){
//            System.out.println(p);
//        }
        System.out.println("==========size==============");
        System.out.println(products.size());

        //display all products
        System.out.println("==========DISPLAY ALL PRODUCTS==========");
        //Product pr


        productRepository.displayAllProducts();


        // sort by ascending order

        System.out.println("=========sort by ascending order========");
        productRepository.sortByPriceAscending();
        productRepository.displayAllProducts();

        //sortByPriceDescending
        System.out.println("===============sortByPriceDescending===========");
        productRepository.sortByPriceDescending();
        productRepository.displayAllProducts();


//        //getHighestPriceProduct()
        System.out.println("============getHighestPriceProduct=========");
        System.out.println(productRepository.getHighestPriceProduct());



        //getLeastPriceProduct()
        System.out.println("==========getLeastPriceProduct=======");
        System.out.println(productRepository.getLeastPriceProduct());

        // MaxDiscountPrice
        System.out.println("==========getMaxDiscountProduct========");
        System.out.println(productRepository.getMaxDiscountProduct());



        //totalValue
        System.out.println("========Total Value=======");
        System.out.println(productRepository.getTotalValue());


        // getAveragePrice
        System.out.println("===========getAveragePrice=========");
        System.out.println(productRepository.getAveragePrice());


        //countProductsAbovePrice
        System.out.println("===============countProductsAbovePrice==========");
        System.out.println(productRepository.countProductsAbovePrice(74999.00));

        //get Products With Discount Above
        System.out.println("================getProductsWithDiscountAbove============");
        System.out.println(productRepository.getProductsWithDiscountAbove(8.0f));


    }


}

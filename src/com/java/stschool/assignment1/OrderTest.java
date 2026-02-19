package com.java.stschool.assignment1;

import java.util.HashSet;

public class OrderTest {
    public static void main(String[] args) {
        String[] productsData = {
                "p-101,Lenovo Laptop,58999.00,10.5",
                "p-102,Dell Inspiron 15,54999.00,8.0",
                "p-103,HP Pavilion 14,62999.00,12.0",
                "p-104,Apple iPhone 14,79999.00,5.0",
                "p-105,Samsung Galaxy S23,74999.00,7.5",
                "p-106,OnePlus 11R,45999.00,9.0",
                "p-107,Boat Rockerz Headphones,2999.00,15.0",
                "p-108,Sony Bravia 43inch TV,52999.00,11.5",
                "p-109,LG Double Door Refrigerator,38999.00,13.0",
                "p-110,Canon EOS 1500D Camera,41999.00,6.5"
        };
        ProductService productService = new ProductService();
        productService.getProducts(productsData);
        OrderRepository orderRepository = new OrderRepository();
        //save new order
        Order order1 = new Order();
        order1.setId("order-101");
        order1.setCustomerName("Customer1");
        //order1-p-101
        //order2--p-102,p-103
        //order3--p-104,p-105,p-106;
        order1.setProducts(productService.getProductsById(new String[]{"p-101"}));
        order1.setStatus("ORDERD");
        Order save = orderRepository.save(order1);
        System.out.println("Order saved successfully: "+save);

        Order order2 = new Order();
        order2.setId("order-102");
        order2.setCustomerName("Customer2");
        order2.setProducts(productService.getProductsById(new String[]{"p-102","p-103"}));
        order2.setStatus("SHIPPED");
        Order save1 = orderRepository.save(order2);
        System.out.println("Shipperd Successfully: "+save1);
        Order order3 = new Order();
        order3.setId("order-103");
        order3.setCustomerName("Customer3");
        order3.setProducts(productService.getProductsById(new String[]{"p-104","p-105","p-106"}));
        order3.setStatus("DELIVERED");

        Order save2 = orderRepository.save(order3);
        System.out.println("Order Saved Successfully : " + save2);
        //get all orders
        System.out.println("----get All orders --------");
        HashSet<Order> allorders = orderRepository.getAll();
        for(Order order : allorders){
            System.out.println(order);
        }

        //get by id
        System.out.println("==========Get order by id: order-103==============");
        Order byId = orderRepository.getById("order-103");
        System.out.println(byId);
        //null
        Order byId1 = orderRepository.getById("order-110");
        System.out.println(byId1);

        //updated
        Order orderToBeUpdated = new Order();
        orderToBeUpdated.setId("order-101");
        orderToBeUpdated.setCustomerName("Customer-4");
        orderToBeUpdated.setProducts(order1.getProducts());
        orderToBeUpdated.setStatus("SHIPPED");
        orderRepository.update(orderToBeUpdated);
        System.out.println("UPDATED SUCCESSFULLY");
        System.out.println(orderToBeUpdated);
        //delete
        orderRepository.delete("order-103");
        System.out.println("order deleted Successfully");
        System.out.println(orderRepository.getAll());

        String[] ordersData = {
                "order-101,customer1,p-101,ORDERED",
                "order-102,customer2,p-102|p-103,SHIPPED",
                "order-103,customer3,p-104|p-105|p-106,DELIVERED"
        };

        HashSet<Order> ordersSet = new HashSet<>();
        for (String orderData : ordersData){
            String[] split = orderData.split(",");
            Order order = new Order();
            order.setId(split[0]);
            order.setCustomerName(split[1]);
            order.setProducts(productService.getProductsById(split[2].split("|")));
            order.setStatus(split[3]);
            ordersSet.add(order);

        }


    }
}

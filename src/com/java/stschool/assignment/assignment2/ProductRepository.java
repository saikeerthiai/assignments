package com.java.stschool.assignment.assignment2;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductRepository {
    ArrayList<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();

    }


    ArrayList<Product> loadProducts(String[] data) {


        for (String productdata : data) {

            String[] split = productdata.split(",");
            products.add(new Product(split[0],
                    split[1],
                    Double.parseDouble(split[2]), Float.parseFloat(split[3])));


        }
        //Product product = new Product();;

        return products;


    }
    //create

    Product save(Product product) {
        System.out.printf("%-5s %-30s %-10s %-10s%n", "ID", "NAME", "MRP", "DISCOUNT %");

        products.add(product);
        System.out.printf("%-5s %-30s %-10s %-10s%n", product.getId(), product.getName(), product.getMaxRetailPrice(), product.getDiscountPercentage());
        return product;


    }

    //get product by id
    Product getProductById(String id) {
        System.out.println("id: " + id);
        Product productById = null;
        for (Product product : products) {
            if (product.getId().equals(id))
                productById = product;


        }
        return productById;


    }
//   Product update(String id, Product product){
//       System.out.println("id: "+id);
//       Iterator<Product> iterator = products.iterator();
//       while (iterator.hasNext()){
//           Product existingData = iterator.next();
//
//           if(existingData.getId().equals(product.getId())) {
//               iterator.remove();
//               //products.add(product);

    /// /               existingData.setName(product.getName());
    /// /               existingData.setMaxRetailPrice(product.getMaxRetailPrice());
    /// /               existingData.setDiscountPercentage(product.getDiscountPercentage());
//               System.out.println(products);
//               break;
//
//
//           }
//       }
//       products.add(product);
//       return product;
//   }
    Product update(String id, Product product) {
        Product existingId = getProductById(id);
        if (existingId != null)
            products.remove(existingId);

        product.setId(id);
        products.add(product);

        return product;


    }


//  void delete(String id){
//      Iterator<Product> iterator = products.iterator();
//      while (iterator.hasNext()){
//          Product existingData = iterator.next();
//          if(existingData.getId().equals(id)) {
//              iterator.remove();
//              break;
//
//          }
//      }
//
//
//
//  }

    public void deleteById(String id) {
        Product ById = getProductById(id);
        if (ById != null)
            products.remove(ById);
    }

    void displayAllProducts() {
        System.out.println("-------------------------------------------------");
        System.out.printf("%-5s %-30s %-10s %-10s%n", "ID", "NAME", "MRP", "DISCOUNT %");
        for (Product product : products) {
            System.out.printf("%-5s %-30s %-10s %-10s%n", product.getId(), product.getName(), product.getMaxRetailPrice(), product.getDiscountPercentage());

        }


//


    }


    //sortByPriceAscending:
    public void sortByPriceAscending() {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getMaxRetailPrice() < products.get(j).getMaxRetailPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);


                }
            }
        }

    }
//sortByPriceDescending()

    void sortByPriceDescending() {
        for (int i = 0;i<products.size()-1;i++){
            for(int j = i+1;j<products.size();j++){
                if(products.get(i).getMaxRetailPrice()>products.get(j).getMaxRetailPrice()){
                    Product temp = products.get(i);
                    products.set(i,products.get(j));
                    products.set(j,temp);
                }


            }
        }

    }

    //
//    Product sortByPriceAscending(){
//       ArrayList<Product> productArrayList;
//       return productArrayList;
//
//    }
    //  Product sortByPriceAscending(Product product){
//        products.sort(Comparator.comparingDouble(Product::getMaxRetailPrice));
//        return product;
//    }


    //getHighestPriceProduct()
    public Product getHighestPriceProduct() {
        Product highestProductPrice = products.get(0);
        for (Product product : products) {
            if (product.getMaxRetailPrice() > highestProductPrice.getMaxRetailPrice())
                highestProductPrice = product;
        }
        return highestProductPrice;
    }

    //getLeastPriceProduct()
    public Product getLeastPriceProduct() {
        Product leastProductPrice = products.get(0);
        for (Product product : products) {
            if (product.getMaxRetailPrice() < leastProductPrice.getMaxRetailPrice())
                leastProductPrice = product;
        }
        return leastProductPrice;
    }

    //getMaxDiscountProduct

    public Product getMaxDiscountProduct() {
        Product maxDiscountProduct = products.get(0);
        for (Product product : products) {
            if (product.getDiscountPercentage() > maxDiscountProduct.getDiscountPercentage())
                maxDiscountProduct = product;
        }
        return maxDiscountProduct;
    }

    //Total value
    public double getTotalValue() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getMaxRetailPrice();
        }

        return sum;

    }

    //getAveragePrice()
//  public double getAveragePrice(){
//        if(products.isEmpty()) {
//            return 0;
//        }
//        double sum = 0;
//        for (Product product : products){
//            sum += product.getMaxRetailPrice();
//        }
//         return sum / products.size();
//
//  }
    public double getAveragePrice() {
        return getTotalValue() / products.size();
    }

    //countProductsAbovePrice
    int countProductsAbovePrice(double price) {
        int count = 0;
        for (Product product : products) {
            if (product.getMaxRetailPrice() > price)
                count++;
        }
        return count;

    }
    //get Products With Discount Above

    public ArrayList<Product> getProductsWithDiscountAbove(float discount) {
        int count = 0;
        for (Product product : products) {
            if (product.getDiscountPercentage() > discount)
                count++;
        }
        return products;


    }


//public ArrayList<Product> getProductsWithDiscountAbove(float discount){
//
//    ArrayList<Product> result = new ArrayList<>();
//
//    for (Product product : products){
//        if(product.getDiscountPercentage() > discount){
//            result.add(product);
//        }
//    }
//
//    return result;
//}


}

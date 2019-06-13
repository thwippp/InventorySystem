/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

/**
 *
 * @author bscha
 */
public class Inventory {

// Do something fancy here
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();

    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProducts = FXCollections.observableArrayList();

//    private static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
// Setters
    public static void addPart(Part part) {
        // do stuff
        allParts.add(part);
    }

    public static void addProduct(Product product) {
        // do stuff
        allProducts.add(product);
    }

    public static void addFilteredPart(Part part) {
        filteredParts.add(part);
    }

    public static void addFilteredProduct(Product product) {
        filteredProducts.add(product);
    }
    
//    public static void addAssociatedPart(Part part){
//        associatedParts.add(part);
//    }

    public static void updatePart(int index, Part part) {
        // do stuff
//        for (Part part : Inventory.getAllParts()) {
//
//            if (part.partId().equals(index)) {
//            
//            }
//        }

    }

    public static void updateProduct(int index, Product product) {
        // do stuff
    }

// Get-Rid-Of-Ers
    public static void deletePart(Part part) {
        // do stuff
    }

    public static void deleteProduct(Product product) {
        // do stuff
    }

    public static void clearFilteredParts() {
        filteredParts.clear();
    }

    public static void clearFilteredProducts() {
        filteredProducts.clear();
    }

// Getters
/*
+ lookupPart(partId:int):Part 
+ lookupProduct(productId:int):Product 
+ lookupPart(partName:String):ObservableList<Part>
+ lookupProduct(productName:String):ObservableList<Product>
+ getAllParts():ObservableList<Part>
+ getAllProducts():ObservableList<Product>
     */
// TODO-- Commented out because I don't know what to return yet
//public Part lookupPart(int partId){
//    //  return Part
//}
//
//public Product lookupProduct(int productId){
//    // return Product
//}
//
//public ObservableList<Part> lookupPart(String partName){
//    // return Part
//}
//
//public ObservableList<Product> lookupProduct(String productName){
//    // return Product
//}
//
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Part> getFilteredParts(String partName) {
        clearFilteredParts();

        for (Part part : Inventory.getAllParts()) {

            if (part.getPartName().equals(partName)) {
                Inventory.addFilteredPart(part);
            }
        }
        return filteredParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public static ObservableList<Product> getFilteredProducts(String productName){
        clearFilteredProducts();

        for (Product product : Inventory.getAllProducts()) {

            if (product.getProductName().equals(productName)) {
                Inventory.addFilteredProduct(product);
            }
        }
        return filteredProducts;
    }
    
//    public static ObservableList<Part> getAllAssociatedParts(){
//        return associatedParts;
//    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bscha
 */
public class Inventory {
    
// Do something fancy here
private static ObservableList<Part> allParts = FXCollections.observableArrayList();
private static ObservableList<Product> allProducts  = FXCollections.observableArrayList();


// Setters
/*
+ addPart(part:Part):void 
+ addProduct(product:Product):void 

+ updatePart(int:index, part:Part):void 
+ updateProduct(int:index, product:Product):void 
*/

public static void addPart(Part part){
    // do stuff
    allParts.add(part);
}

public static void addProduct(Product product){
    // do stuff
    allProducts.add(product);
}

public void updatePart(int index, Part part){
    // do stuff
}

public void updateProduct(int index, Product product){
    // do stuff
}


// Get-Rid-Of-Ers
/*
+ deletePart(part:Part):void 
+ deleteProduct(product:Product):void
*/

public void deletePart(Part part){
    // do stuff
}

public void deleteProduct(Product product){
    // do stuff
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

// Commented out because I don't know what to return yet
//public Part lookupPart(int partId){
//    //  return Part
//}
//
//public Product looupProduct(int productId){
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
public static ObservableList<Part> getAllParts(){
   return allParts;
}

public static ObservableList<Product> getAllProducts(){
    return allProducts;
}
    
      
}

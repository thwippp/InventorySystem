package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Brian Schaffeld
 */
public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();

    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProducts = FXCollections.observableArrayList();

    // Parts ///////////////////////////////////////////////////////////////////
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

    public static void addPart(Part part) {
        allParts.add(part);
    }

    public static void deletePart(Part part) {
        allParts.remove(part);
    }

    public static void addFilteredPart(Part part) {
        filteredParts.add(part);
    }

    public static boolean partExists(int id) {
        for (Part p : Inventory.getAllParts()) {
            if (p.getPartId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void updatePart(int id, Part part) {
        int index = -1;
        for (Part p : Inventory.getAllParts()) {
            index++;
            if (p.getPartId() == id) {
                Inventory.getAllParts().set(index, part);
            }
        }
    }

    //TODO getpartbyid = lookuppart
    public static Part getPartById(int id) {
        for (Part p : Inventory.getAllParts()) {
            if (p.getPartId() == id) {
                if (Model.InHousePart.class.isInstance(p)) {
                    p = (InHousePart) p;
                } else if (Model.OutsourcedPart.class.isInstance(p)) {
                    p = (OutsourcedPart) p;
                }
                return p;
            }
        }
        return null;
    }

    public static void clearFilteredParts() {
        filteredParts.clear();
    }

    // Products ///////////////////////////////////////////////////////////////
    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    public static void deleteProduct(Product product) {
        allProducts.remove(product);
    }

    public static void addFilteredProduct(Product product) {
        filteredProducts.add(product);
    }

    public static boolean productExists(int id) {
        for (Product p : Inventory.getAllProducts()) {
            if (p.getProductId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void updateProduct(int id, Product product) {
        int index = -1;
        for (Product p : Inventory.getAllProducts()) {
            index++;
            if (p.getProductId() == id) {
                Inventory.getAllProducts().set(index, product);
            }
        }
    }

    public static void clearFilteredProducts() {
        filteredProducts.clear();
    }
// TODO getproductbyid = lookupproduct

    public static Product getProductById(int id) {
        for (Product p : Inventory.getAllProducts()) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public static ObservableList<Product> getFilteredProducts(String productName) {
        clearFilteredProducts();
        for (Product product : Inventory.getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                Inventory.addFilteredProduct(product);
            }
        }
        return filteredProducts;
    }

}

// TODO-- Implement?
//public ObservableList<Part> lookupPart(String partName){
//    // return Part
//}
//
//public ObservableList<Product> lookupProduct(String productName){
//    // return Product
//}
//


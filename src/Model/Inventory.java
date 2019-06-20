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
    private static int partIdAutoGen = 0;

    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
    private static int productIdAutoGen = 0;

    // Parts ///////////////////////////////////////////////////////////////////
    public static int getPartIdAutoGen() {
        return partIdAutoGen;
    }

    public static void setPartIdAutoGen(int partIdAutoGen) {
        Inventory.partIdAutoGen = partIdAutoGen;
    }

    public static void cancelPartIdAutoGen() {
        Inventory.setPartIdAutoGen(Inventory.getPartIdAutoGen() - 1);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    // Looks for part (formerly getFilteredParts)
    public static ObservableList<Part> lookupPart(String partName) {
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
        boolean exists = false;
        for (Part p : Inventory.getAllParts()) {
            if (p.getPartId() == id) {
                exists = true;
            }
        }
        return exists;
    }

    public static void updatePart(int index, Part part) {
        int i = -1;
        for (Part p : Inventory.getAllParts()) {
            i++;
            if (p.getPartId() == index) {
                Inventory.getAllParts().set(i, part);
            }
        }
    }

    public static Part lookupPart(int partId) {
        for (Part p : Inventory.getAllParts()) {
            if (p.getPartId() == partId) {
                if (Model.InHousePart.class.isInstance(p)) {
                    p = (InHousePart) p;
                    return p;
                } else if (Model.OutsourcedPart.class.isInstance(p)) {
                    p = (OutsourcedPart) p;
                    return p;
                }
//                return p;
            }
        }
        return null;
    }

    public static void clearFilteredParts() {
        filteredParts.clear();
    }

    // Products ///////////////////////////////////////////////////////////////
    public static int getProductIdAutoGen() {
        return productIdAutoGen;
    }

    public static void setProductIdAutoGen(int productIdAutoGen) {
        Inventory.productIdAutoGen = productIdAutoGen;
    }

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

    public static void updateProduct(int index, Product product) {
        int i = -1;
        for (Product p : Inventory.getAllProducts()) {
            i++;
            if (p.getProductId() == index) {
                Inventory.getAllProducts().set(i, product);
            }
        }
    }

    public static void clearFilteredProducts() {
        filteredProducts.clear();
    }

    public static Product lookupProduct(int productId) {
        for (Product p : Inventory.getAllProducts()) {
            if (p.getProductId() == productId) {
                return p;
            }
        }
        return null;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    // Formerly getFilteredProducts
    public static ObservableList<Product> lookupProduct(String productName) {
        clearFilteredProducts();
        for (Product product : Inventory.getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                Inventory.addFilteredProduct(product);
            }
        }
        return filteredProducts;
    }

}

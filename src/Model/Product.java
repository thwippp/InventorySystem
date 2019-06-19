package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Brian Schaffeld
 */
public class Product {

    // Instance Variables
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    private int productId;
    private String productName;
    private double productPrice;
    private int productStock;
    private int productMin;
    private int productMax;

    public Product(String productName, double productPrice, int productStock, int productMin, int productMax) {
//        this.productId = productId;
        int nextId = Inventory.getProductIdAutoGen() + 1;
        setProductId(nextId);
        Inventory.setProductIdAutoGen(nextId);
        
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productMin = productMin;
        this.productMax = productMax;
    }

    // Setter Methods
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public void setProductMin(int productMin) {
        this.productMin = productMin;
    }

    public void setProductMax(int productMax) {
        this.productMax = productMax;
    }

    // Getter Methods
    public int getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public int getProductStock() {
        return this.productStock;
    }

    public int getProductMin() {
        return this.productMin;
    }

    public int getProductMax() {
        return this.productMax;
    }

    // Associated Parts
    public void addAssociatedPart(Part associatedPart) {
        this.associatedParts.add(associatedPart);
    }

    public void deleteAssociatedPart(Part associatedPart) {
        this.associatedParts.remove(associatedPart);
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return this.associatedParts;
    }

}

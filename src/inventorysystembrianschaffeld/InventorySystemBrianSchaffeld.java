/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystembrianschaffeld;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author bscha
 */
public class InventorySystemBrianSchaffeld extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Inventory System || Brian Schaffeld || ID# 000790777"); // TODO-- catchy name

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create data here  partId, partName, partPrice, partStock, partMin, partMax
        InHousePart a = new InHousePart(1, "Part A", 9.99, 10, 1, 10, 5);
        InHousePart b = new InHousePart(2, "Part B", 19.99, 20, 11, 101, 9);
        OutsourcedPart c = new OutsourcedPart(3, "Part C", 29.99, 30, 21, 120, "Company C");
        OutsourcedPart d = new OutsourcedPart(4, "Part D", 39.99, 40, 33, 150, "Company D");

        // Adds parts to the ObservableLists/ArrayLists
        Inventory.addPart(a);
        Inventory.addPart(b);
        Inventory.addPart(c);
        Inventory.addPart(d);

        // Creates product data 
        Product pA = new Product(1, "Product A", 1.11, 1, 0, 1);
        Product pB = new Product(2, "Product B", 2.22, 2, 1, 2);
        Product pC = new Product(3, "Product C", 3.33, 3, 2, 3);

        Inventory.addProduct(pA);
        Inventory.addProduct(pB);
        Inventory.addProduct(pC);

        // launches program
        launch(args);
    }

}

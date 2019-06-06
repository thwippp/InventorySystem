/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bscha
 */
public class MainScreenController implements Initializable {
    // Instance Variables for Parts
    @FXML private Label partsLabel;
    @FXML private TableView<Part> partsTableView;
    @FXML private TableColumn<Part, Integer> partsIdTableColumn;
    @FXML private TableColumn<Part, String> partsNameTableColumn;
    @FXML private TableColumn<Part, Integer> partsInventoryTableColumn;
    @FXML private TableColumn<Part, Double> partsPriceTableColumn;
    @FXML private Button partsSearchButton;
    @FXML private TextField partsSearchTextField;
    @FXML private Button partsAddButton;
    @FXML private Button partsModifyButton;
    @FXML private Button partsDeleteButton;
   
    // Instance Variables for Products
    @FXML private Label productsLabel;
    @FXML private TableView<Product> productsTableView;
    @FXML private TableColumn<Product, Integer> productsIdTableColumn;
    @FXML private TableColumn<Product, String> productsNameTableColumn;
    @FXML private TableColumn<Product, Integer> productsInventoryTableColumn;
    @FXML private TableColumn<Product, Double> productsPriceTableColumn;
    @FXML private Button productsSearchButton;
    @FXML private TextField productsSearchTextField;
    @FXML private Button productsAddButton;
    @FXML private Button productsModifyButton;
    @FXML private Button productsDeleteButton;

    // Instance variables for Main Screen
    @FXML private Button exitButton;
    
    /**
     * 
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        partsTableView.setItems(Inventory.getAllParts());
        partsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partsInventoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));   
    }  
    
    // Add button action
    
    // Exit button action
    @FXML private void exitButtonAction(){
        // Gets the current stage, casts as a stage, gets the scene holding
        // the exit button, gets the current window
        Stage stage = (Stage) exitButton.getScene().getWindow();
        
        // Closes the window
         stage.close();
    }
    
    
}

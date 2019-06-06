/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bscha
 */
public class MainScreenController implements Initializable {
    // Instance Variables for Parts
    @FXML private Label partsLabel;
    @FXML private TableView partsTableView;
    @FXML private TableColumn partsIdTableColumn;
    @FXML private TableColumn partsNameTableColumn;
    @FXML private TableColumn partsInventoryTableColumn;
    @FXML private TableColumn partsPriceTableColumn;
    @FXML private Button partsSearchButton;
    @FXML private TextField partsSearchTextField;
    @FXML private Button partsAddButton;
    @FXML private Button partsModifyButton;
    @FXML private Button partsDeleteButton;
   
    // Instance Variables for Products
    @FXML private Label productsLabel;
    @FXML private TableView productsTableView;
    @FXML private TableColumn productsIdTableColumn;
    @FXML private TableColumn productsNameTableColumn;
    @FXML private TableColumn productsInventoryTableColumn;
    @FXML private TableColumn productsPriceTableColumn;
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

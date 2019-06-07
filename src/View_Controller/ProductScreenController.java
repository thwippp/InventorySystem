/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
public class ProductScreenController implements Initializable {
    // Instance Variables

    // Labels and Buttons
    @FXML
    private Label addProductLabel;
    @FXML
    private RadioButton productInHouseRadioButton;
    @FXML
    private RadioButton productOutsourcedRadioButton;
    @FXML
    private Label productIdLabel;
    @FXML
    private Label productNameLabel;
    @FXML
    private Label productInventoryLabel;
    @FXML
    private Label productPriceLabel;
    @FXML
    private Label productMinLabel;
    @FXML
    private Label productMaxLabel;
    @FXML
    private Label productCompanyNameLabel;
    @FXML
    private Button productSaveButton;
    @FXML
    private Button productCancelButton;

    // Text Fields
    @FXML
    private TextField productIdTextField;
    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productInventoryTextField;
    @FXML
    private TextField productPriceTextField;
    @FXML
    private TextField productMinTextField;
    @FXML
    private TextField productMaxTextField;
    @FXML
    private TextField productCompanyNameTextField;

    // Instance Variables for Parts
    @FXML
    private Label partsLabel;
    @FXML
    private TableView partsTableView;
    @FXML
    private TableColumn partsIdTableColumn;
    @FXML
    private TableColumn partsNameTableColumn;
    @FXML
    private TableColumn partsInventoryTableColumn;
    @FXML
    private TableColumn partsPriceTableColumn;
    @FXML
    private Button partsSearchButton;
    @FXML
    private TextField partsSearchTextField;
    @FXML
    private Button partsAddButton;

    // Instance Variables for Products
    @FXML
    private Label productsLabel;
    @FXML
    private TableView productsTableView;
    @FXML
    private TableColumn productsIdTableColumn;
    @FXML
    private TableColumn productsNameTableColumn;
    @FXML
    private TableColumn productsInventoryTableColumn;
    @FXML
    private TableColumn productsPriceTableColumn;
    @FXML
    private Button productsDeleteButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Gets current list of parts in ProductScreen
        partsTableView.setItems(Inventory.getAllParts());
        partsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partsInventoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
    }

    // Part save button action
    @FXML
    private void productSaveButtonAction() throws IOException {
        // Do Some stuff
        // Get fields (can do some checking here
        // call new InHouse or Outsourced Part Constructor

        // Go back to main screen
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) productCancelButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Part cancel button action
    @FXML
    private void productCancelButtonAction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) productCancelButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

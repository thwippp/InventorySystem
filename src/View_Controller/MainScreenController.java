/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML
    private Label partsLabel;
    @FXML
    private TableView<Part> partsTableView;
    @FXML
    private TableColumn<Part, Integer> partsIdTableColumn;
    @FXML
    private TableColumn<Part, String> partsNameTableColumn;
    @FXML
    private TableColumn<Part, Integer> partsInventoryTableColumn;
    @FXML
    private TableColumn<Part, Double> partsPriceTableColumn;
    @FXML
    private Button partsSearchButton;
    @FXML
    private TextField partsSearchTextField;
    @FXML
    private Button partsAddButton;
    @FXML
    private Button partsModifyButton;
    @FXML
    private Button partsDeleteButton;

    // Instance Variables for Products
    @FXML
    private Label productsLabel;
    @FXML
    private TableView<Product> productsTableView;
    @FXML
    private TableColumn<Product, Integer> productsIdTableColumn;
    @FXML
    private TableColumn<Product, String> productsNameTableColumn;
    @FXML
    private TableColumn<Product, Integer> productsInventoryTableColumn;
    @FXML
    private TableColumn<Product, Double> productsPriceTableColumn;
    @FXML
    private Button productsSearchButton;
    @FXML
    private TextField productsSearchTextField;
    @FXML
    private Button productsAddButton;
    @FXML
    private Button productsModifyButton;
    @FXML
    private Button productsDeleteButton;

    // Instance variables for Main Screen
    @FXML
    private Button exitButton;

    /**
     *
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // Get list of parts in Main Screen
        partsTableView.setItems(Inventory.getAllParts());
        partsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partsInventoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        // Get list of products in Main Screen
        productsTableView.setItems(Inventory.getAllProducts());
        productsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productsInventoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("productStock"));
        productsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

    }

    // Parts search button action
    @FXML
    void partsSearchButtonAction(ActionEvent event) {
        //TODO
        // Get search term (dynamically find field based on input type?)-- right now part name
        // Get list of current parts
        // Find parts that match
        // Return parts that match --> add them to the tableview

        String searchTerm = partsSearchTextField.getText();

        if (searchTerm.equals("")) {
            // Resets table
            partsTableView.setItems(null);
            partsTableView.setItems(Inventory.getAllParts());
        } else {
            partsTableView.setItems(Inventory.getFilteredParts(searchTerm));
        }

//        if(foundParts.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.initModality(Modality.APPLICATION_MODAL);
//            alert.setTitle("No Part match found");
//            alert.setHeaderText("No Part Names found matching " + term); 
//            alert.showAndWait();
//        } else {
//            partTable.setItems(foundParts);
//        }
    }

    // Parts add button action
    @FXML
    private void partsAddButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/PartScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) partsAddButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Parts modify button action
    @FXML
    private void partsModifyButtonAction(ActionEvent event) throws IOException {
        // TODO-- clean this code up and standardize it across the other buttons
        Stage stage;
        Parent root;
        stage = (Stage) partsModifyButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/View_Controller/PartScreen.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        PartScreenController controller = loader.getController();
        Part p = partsTableView.getSelectionModel().getSelectedItem();
        controller.setModifyPart(p);

//        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/PartScreen.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) partsModifyButton.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
    }

    // Part Delete Button Action
    @FXML
    private void partDeleteButtonAction() {
        Part p = partsTableView.getSelectionModel().getSelectedItem();
        partsTableView.getItems().remove(p);
    }

    // Products Search Button Action
    @FXML
    void productsSearchButtonAction(ActionEvent event) {
        //TODO  see partsSearchButtonAction

        String searchTerm = productsSearchTextField.getText();

        if (searchTerm.equals("")) {
            // Resets table
            productsTableView.setItems(null);
            productsTableView.setItems(Inventory.getAllProducts());
        } else {
            productsTableView.setItems(Inventory.getFilteredProducts(searchTerm));
        }
    }

    // Product add button action
    @FXML
    private void productsAddButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/ProductScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) productsAddButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Product modify button action
    @FXML
    private void productsModifyButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/ProductScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) productsModifyButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Product delete button action
    @FXML
    private void productsDeleteButtonAction() {
        Product p = productsTableView.getSelectionModel().getSelectedItem();
        productsTableView.getItems().remove(p);

    }

    // Exit button action
    @FXML
    private void exitButtonAction() {
        // Gets the current stage, casts as a stage, gets the scene holding
        // the exit button, gets the current window
        Stage stage = (Stage) exitButton.getScene().getWindow();

        // Closes the window
        stage.close();
    }

}

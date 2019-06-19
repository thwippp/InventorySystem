package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brian Schaffeld
 */
public class ProductScreenController implements Initializable {
    // Instance Variables

    // Labels and Buttons
    @FXML
    private Label addProductLabel;
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

    // Instance Variables for Associated Parts
    @FXML
    private Label associatedPartsLabel;
    @FXML
    private TableView<Part> associatedPartsTableView;
    @FXML
    private TableColumn<Part, Integer> associatedPartsIdTableColumn;
    @FXML
    private TableColumn<Part, String> associatedPartsNameTableColumn;
    @FXML
    private TableColumn<Part, Integer> associatedPartsInventoryTableColumn;
    @FXML
    private TableColumn<Part, Double> associatedPartsPriceTableColumn;
    @FXML
    private Button associatedPartsDeleteButton;

    private static Product selectedProduct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Disables text field because it is automatically generated
        productIdTextField.setDisable(true);
        productIdTextField.setText(String.valueOf(Inventory.getProductIdAutoGen() + 1));

        // TODO
        // Gets current list of parts in ProductScreen
        partsTableView.setItems(Inventory.getAllParts());
        partsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partsInventoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
    }

    @FXML
    void partsSearchButtonAction(ActionEvent event) {
        //TODO see MS parts to do some handling

        String searchTerm = partsSearchTextField.getText();

        if (searchTerm.equals("")) {
            // Resets table
            partsTableView.setItems(null);
            partsTableView.setItems(Inventory.getAllParts());
        } else {
            partsTableView.setItems(Inventory.lookupPart(searchTerm));
        }
    }

    @FXML
    private void partsAddButtonAction() {
        Part associatedPart = (Part) partsTableView.getSelectionModel().getSelectedItem();

        // TODO-- if I hit cancel, it shouldn't add it to the Product
        // Should do some sort of temporary tableview and then add the temp tableview
        // to the associatedPartsTableView on productsSaveButtonAction
        associatedPartsTableView.getItems().add(associatedPart);

    }

    // Product save button action
    @FXML
    private void productSaveButtonAction() throws IOException {
        // if product exists, update it
        // if no product exists, add new product

        int id = Integer.parseInt(productIdTextField.getText());
        String name = productNameTextField.getText();
        double price = Double.parseDouble(productPriceTextField.getText());
        int stock = Integer.parseInt(productInventoryTextField.getText());
        int min = Integer.parseInt(productMinTextField.getText());
        int max = Integer.parseInt(productMaxTextField.getText());
        if (Inventory.productExists(id)) {
            Product existingProduct = Inventory.lookupProduct(id);
            existingProduct.setProductId(id);
            existingProduct.setProductName(name);
            existingProduct.setProductPrice(price);
            existingProduct.setProductStock(stock);
            existingProduct.setProductMin(min);
            existingProduct.setProductMax(max);

//            Inventory.updateProduct(id, existingProduct);
        } else {
//            String name = productNameTextField.getText();
//            double price = Double.parseDouble(productPriceTextField.getText());
//            int stock = Integer.parseInt(productInventoryTextField.getText());
//            int min = Integer.parseInt(productMinTextField.getText());
//            int max = Integer.parseInt(productMaxTextField.getText());

            Product savedProduct = new Product(name, price, stock, min, max);
            Inventory.addProduct(savedProduct);
        }

        // Go back to main screen
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) productSaveButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Part cancel button action
    @FXML
    private void productCancelButtonAction() throws IOException {
        String title = "Cancel";
        String header = "Are you sure you want to cancel?";
        String content = "Are you sure you want to cancel and return to the Main Screen?";

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) productCancelButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            // User Cancelled
            //   stay on ProductScreen
        }
    }

    // Product Delete Button Action
    @FXML
    private void associatedPartsDeleteButtonAction() {
        String title = "Delete";
        String header = "Really?";
        String content = "Are you sure you want to delete that Associated Part?";

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            Part dissociatedPart = (Part) associatedPartsTableView.getSelectionModel().getSelectedItem();
            associatedPartsTableView.getItems().remove(dissociatedPart);
        } else {
            // User Cancelled
            //   do not delete AssociatedPart
        }

    }

    public void setModifyProduct(Product product) {
        if (product != null) {

            selectedProduct = product;

            productIdTextField.setText(String.valueOf(selectedProduct.getProductId()));
            productNameTextField.setText(selectedProduct.getProductName());
            productPriceTextField.setText(String.valueOf(selectedProduct.getProductPrice()));
            productInventoryTextField.setText(String.valueOf(selectedProduct.getProductStock()));
            productMinTextField.setText(String.valueOf(selectedProduct.getProductMin()));
            productMaxTextField.setText(String.valueOf(selectedProduct.getProductMax()));

            associatedPartsTableView.setItems(selectedProduct.getAllAssociatedParts());
            associatedPartsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
            associatedPartsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
            associatedPartsInventoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
            associatedPartsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        }
    }
}

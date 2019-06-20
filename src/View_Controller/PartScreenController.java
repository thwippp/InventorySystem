/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brian Schaffeld
 */
public class PartScreenController implements Initializable {
    // Instance Variables

    // Labels and Buttons
//    @FXML
//    private Label addPartLabel;
    @FXML
    private RadioButton partInHouseRadioButton;
    @FXML
    private RadioButton partOutsourcedRadioButton;
//    @FXML
//    private Label partIdLabel;
//    @FXML
//    private Label partNameLabel;
//    @FXML
//    private Label partInventoryLabel;
//    @FXML
//    private Label partPriceLabel;
//    @FXML
//    private Label partMinLabel;
//    @FXML
//    private Label partMaxLabel;
    @FXML
    private Label partMICNLabel;
    @FXML
    private Button partSaveButton;
    @FXML
    private Button partCancelButton;

    // Text Fields
    @FXML
    private TextField partIdTextField;
    @FXML
    private TextField partNameTextField;
    @FXML
    private TextField partInventoryTextField;
    @FXML
    private TextField partPriceTextField;
    @FXML
    private TextField partMinTextField;
    @FXML
    private TextField partMaxTextField;
    @FXML
    private TextField partMICNTextField;

    private static Part selectedPart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initializes partIdTextField value
        int id = Inventory.getPartIdAutoGen() + 1;
        partIdTextField.setText(String.valueOf(id));

        // Disables text field because it is automatically generated
        partIdTextField.setDisable(true);

        final ToggleGroup partRadioButtonToggleGroup = new ToggleGroup();
        partInHouseRadioButton.setToggleGroup(partRadioButtonToggleGroup);
        partOutsourcedRadioButton.setToggleGroup(partRadioButtonToggleGroup);
    }

    //
    public void setModifyPart(Part part) {
        if (part != null) {
            selectedPart = part;
            partIdTextField.setText(String.valueOf(selectedPart.getPartId()));  // overrides initial value if modifying
            partNameTextField.setText(selectedPart.getPartName());
            partPriceTextField.setText(String.valueOf(selectedPart.getPartPrice()));
            partInventoryTextField.setText(String.valueOf(selectedPart.getPartStock()));
            partMinTextField.setText(String.valueOf(selectedPart.getPartMin()));
            partMaxTextField.setText(String.valueOf(selectedPart.getPartMax()));

            // Checks for the type of part and sets the Machine Id or
            //   Company Name based on the subclass
            if (Model.InHousePart.class.isInstance(selectedPart)) {
                partInHouseRadioButton.setSelected(true);
                partMICNLabel.setText("Machine Id");
                String value = String.valueOf(((InHousePart) selectedPart).getMachineId());
                partMICNTextField.setText(value);
            } else if (Model.OutsourcedPart.class.isInstance(selectedPart)) {
                partOutsourcedRadioButton.setSelected(true);
                partMICNLabel.setText("Company Name");
                String value = ((OutsourcedPart) selectedPart).getCompanyName();
                partMICNTextField.setText(value);
            }
        }
    }

    // Radio button actions
    @FXML
    void inHouseRadioButtonPressed() {
        String s = "Machine Id";
        partMICNLabel.setText(s);
        partMICNTextField.setPromptText(s);
    }

    @FXML
    void outsourcedRadioButtonPressed() {
        String s = "Company Name";
        partMICNLabel.setText(s);
        partMICNTextField.setPromptText(s);
    }

    @FXML
    private void partSaveButtonAction() throws IOException {

        int id = Integer.parseInt(partIdTextField.getText());
        String name = partNameTextField.getText();
        double price = Double.parseDouble(partPriceTextField.getText());
        int stock = Integer.parseInt(partInventoryTextField.getText());
        int min = Integer.parseInt(partMinTextField.getText());
        int max = Integer.parseInt(partMaxTextField.getText());

        if (min <= max) {

            // if part exists, get part type.  Get radio button.  Cast to type of button.
            // if part not exists, get radio button.  Add new part of type of button.
            Part existingPart = Inventory.lookupPart(id);

            boolean isInHouse = partInHouseRadioButton.isSelected();
            boolean isOutsourced = partOutsourcedRadioButton.isSelected();

            // If part exists...
            if (existingPart != null) {
                Inventory.deletePart(existingPart);
                Inventory.cancelPartIdAutoGen();
            }
            if (isInHouse) {
                int mIDCN = Integer.parseInt(partMICNTextField.getText());
                InHousePart existingInHousePart = new InHousePart(name, price, stock, min, max, mIDCN);
                existingInHousePart.setPartId(id);
                Inventory.addPart(existingInHousePart);

                // Go back to main screen
                Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) partSaveButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else if (isOutsourced) {
                String mIDCN = partMICNTextField.getText();
                OutsourcedPart existingOutsourcedPart = new OutsourcedPart(name, price, stock, min, max, mIDCN);
                existingOutsourcedPart.setPartId(id);
                Inventory.addPart(existingOutsourcedPart);

                // Go back to main screen
                Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) partSaveButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                // no part type selected
                String title = "Warning";
                String header = "Invalid Part";
                String content = "Please ensure that you have selected a valid Part Type: 'InHouse or Outsourced Part'";

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(title);
                alert.setHeaderText(header);
                alert.setContentText(content);
                alert.showAndWait();
            }

        } else {
            String title = "Warning";
            String header = "Data input error";
            String content = "Max value is less than Min value.  Please try again.";

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait();
        }
    }

    // Part cancel button action
    @FXML
    private void partCancelButtonAction() throws IOException {
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
            Stage stage = (Stage) partCancelButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            // User Cancelled
            //   stay on PartScreen
        }

    }

}

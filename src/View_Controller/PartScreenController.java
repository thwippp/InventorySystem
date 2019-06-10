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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bscha
 */
public class PartScreenController implements Initializable {
    // Instance Variables

    // TODO make radiobuttons in a group
    // Labels and Buttons
    @FXML
    private Label addPartLabel;
    @FXML
    private RadioButton partInHouseRadioButton;
    @FXML
    private RadioButton partOutsourcedRadioButton;
    @FXML
    private Label partIdLabel;
    @FXML
    private Label partNameLabel;
    @FXML
    private Label partInventoryLabel;
    @FXML
    private Label partPriceLabel;
    @FXML
    private Label partMinLabel;
    @FXML
    private Label partMaxLabel;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final ToggleGroup partRadioButtonToggleGroup = new ToggleGroup();
        partInHouseRadioButton.setToggleGroup(partRadioButtonToggleGroup);
        partOutsourcedRadioButton.setToggleGroup(partRadioButtonToggleGroup);
    }

    
    // Radio button actions
    @FXML void inHouseRadioButtonPressed(){
        String s = "Machine Id";
        partMICNLabel.setText(s);
        partMICNTextField.setPromptText(s);
    }
    
    @FXML void outsourcedRadioButtonPressed(){
        String s = "Company Name";
        partMICNLabel.setText(s);
        partMICNTextField.setPromptText(s);
    }
    
    // Part save button action
    @FXML
    private void partSaveButtonAction() throws IOException {
        // Do Some stuff
        // TODO-- Get fields (can do some checking here
        int id = Integer.parseInt(partIdTextField.getText());
        String name = partNameTextField.getText();
        double price = Double.parseDouble(partPriceTextField.getText());
        int stock = Integer.parseInt(partInventoryTextField.getText());
        int min = Integer.parseInt(partMinTextField.getText());
        int max = Integer.parseInt(partMaxTextField.getText());
//        int mIDCN = Integer.parseInt(partMICNTextField.getText());


        if (partInHouseRadioButton.isSelected()) {
            int mIDCN = Integer.parseInt(partMICNTextField.getText());
            InHousePart p = new InHousePart(id, name, price, stock, min, max, mIDCN);
            Inventory.addPart(p);
        } else {
            String mIDCN = partMICNTextField.getText();
            OutsourcedPart p = new OutsourcedPart(id, name, price, stock, min, max, mIDCN);
            Inventory.addPart(p);
        }

        // Go back to main screen
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) partCancelButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Part cancel button action
    @FXML
    private void partCancelButtonAction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) partCancelButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

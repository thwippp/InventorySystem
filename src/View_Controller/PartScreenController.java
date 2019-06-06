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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author bscha
 */

public class PartScreenController implements Initializable {
    // Instance Variables
    
    // Labels and Buttons
    @FXML private Label addPartLabel;
    @FXML private RadioButton partInHouseRadioButton;
    @FXML private RadioButton partOutsourcedRadioButton;
    @FXML private Label partIdLabel;
    @FXML private Label partNameLabel;
    @FXML private Label partInventoryLabel;
    @FXML private Label partPriceLabel;
    @FXML private Label partMinLabel;
    @FXML private Label partMaxLabel;
    @FXML private Label partCompanyNameLabel;
    @FXML private Button partSaveButton;
    @FXML private Button partCancelButton;
    
    // Text Fields
    @FXML private TextField partIdTextField;
    @FXML private TextField partNameTextField;
    @FXML private TextField partInventoryTextField;
    @FXML private TextField partPriceTextField;
    @FXML private TextField partMinTextField;
    @FXML private TextField partMaxTextField;
    @FXML private TextField partCompanyNameTextField;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

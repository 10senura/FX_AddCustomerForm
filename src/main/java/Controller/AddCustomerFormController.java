package Controller;

import Model.Customer;
import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AddCustomerFormController {

    @FXML
    private JFXButton btnAddCustomer;

    @FXML
    private JFXButton btnDeleteCustomer;

    @FXML
    private JFXButton btnSearchCustomer;

    @FXML
    private JFXButton btnUpdateCustomer;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddCustomeronAction(ActionEvent event) {

    }

    public void btnDeleteCustomeronAction(ActionEvent actionEvent) {
    }
    public void btnSearchCustomeronAction(ActionEvent actionEvent) {
    }
    public void btnUpdateCustomeronAction(ActionEvent actionEvent) {
    }

     public void clearTxtfield(){
         txtId.setText(null);
         txtName.setText(null);
         txtAddress.setText(null);
         txtSalary.setText(null);
     }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtSalary.setText(null);
    }
}

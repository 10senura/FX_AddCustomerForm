package Controller;

import Model.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    public JFXComboBox cmbTitle;
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

            String Id = txtId.getText();
            String Name=txtName.getText();
            String Address=txtAddress.getText();
            Double Salary = Double.parseDouble(txtSalary.getText());

        Customer customer = new Customer(Id, Name, Address, Salary);

        List<Customer> CustomerList = DBConnection.getInstance().getConnection();
        CustomerList.add(customer);
        clearTxtfield();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Title = FXCollections.observableArrayList();
        Title.add("MR");
        Title.add("MISS");
        cmbTitle.setItems(Title);

    }

    public void ViewTabelOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/viewcustomer_form_controller.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

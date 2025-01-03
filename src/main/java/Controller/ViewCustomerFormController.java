package Controller;

import Model.Customer;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    public TableView tblCustomer;

    @FXML
    private TableColumn clmAddress;

    @FXML
    private TableColumn clmId;

    @FXML
    private TableColumn clmSalary;

    @FXML
    private TableColumn clmName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clmId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        clmSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        lodetabel();
    }

    public void lodetabel(){
        ObservableList<Customer> CustomerObservableList = FXCollections.observableArrayList();
        List<Customer> DBList = DBConnection.getInstance().getConnection();
        DBList.forEach(obj->{
            CustomerObservableList.add(obj);
        });

        CustomerObservableList.add(new Customer("C001","senura","anamaduwa",1200.0));
        CustomerObservableList.add(new Customer("C001","senura","anamaduwa",1200.0));
        CustomerObservableList.add(new Customer("C001","senura","anamaduwa",1200.0));
        CustomerObservableList.add(new Customer("C001","senura","anamaduwa",1200.0));
        tblCustomer.setItems(CustomerObservableList);
    }

    public void btnRelodeOnAction(ActionEvent actionEvent) {
        lodetabel();
    }

}

package Controller;

import Model.Customer;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    public TableView <Customer> tblCustomer;
    public TextField txtName;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtSalary;

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

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((((observableValue, o, newValue) ->{
            setTextToValues(newValue);
        })));

        clmId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        clmSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        lodetabel();
    }

    private void setTextToValues(Customer newValue) {

        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
        txtSalary.setText(String.valueOf(newValue.getSalary()));
    }

    public void lodetabel(){
        ObservableList<Customer> CustomerObservableList = FXCollections.observableArrayList();
        List<Customer> DBList = DBConnection.getInstance().getConnection();
        DBList.forEach(obj->{
            CustomerObservableList.add(obj);
        });

        tblCustomer.setItems(CustomerObservableList);

        try {
            String sql="select * from customer";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root","1234");
            PreparedStatement PSVM = connection.prepareStatement(sql);
            ResultSet resultSet = PSVM.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("address"));
                System.out.println(resultSet.getString("salary"));

                Customer customer = new Customer(
                        resultSet.getString("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Address"),
                        resultSet.getDouble("Salary")
                );
                System.out.println(customer);
                CustomerObservableList.add(customer);
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    public void btnRelodeOnAction(ActionEvent actionEvent) {
        lodetabel();
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {

        Customer customer = new Customer(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())

        );
        try {
            String sql="INSERT INTO customer values (?,?,?,?)";
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root","1234" );
            PreparedStatement pstm= connection.prepareStatement(sql);
            pstm.setObject(1,customer.getId());
            pstm.setObject(2,customer.getName());
            pstm.setObject(3,customer.getAddress());
            pstm.setDouble(4,customer.getSalary());

            boolean b = pstm.executeUpdate()>0;
            System.out.println(b);

            if (b){
                new Alert(Alert.AlertType.INFORMATION," Added successfully!").show();
            }

            lodetabel();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}

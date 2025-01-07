package Controller.Item;

import Controller.Customer.CustomerController;
import Controller.Customer.CustomerService;
import Model.Customer;
import Model.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.ToString;

import java.net.URL;
import java.util.ResourceBundle;
@ToString

public class ItemFormController implements Initializable {

    @FXML
    private TableColumn  clmCode;

    @FXML
    private TableColumn<?, ?> clmDescription;

    @FXML
    private TableColumn<?, ?> clmQtyOnHand;

    @FXML
    private TableColumn<?, ?> clmUnitPrice;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    ItemService Service= new ItemController();

    @FXML
    void btnAddItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tblItem.getSelectionModel().selectedItemProperty().addListener((((observableValue, oldValue, newValue) ->{
            setTextToValues(newValue);
        })));

        clmCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        clmUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        clmQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        lodetabel();
    }

    private void setTextToValues(Item newValue) {
        txtCode.setText(newValue.getCode());
        txtDescription.setText(newValue.getDescription());
        txtPrice.setText(String.valueOf(newValue.getPrice()));
        txtQty.setText(String.valueOf(newValue.getQtyOnHand()));
    }

    public void lodetabel(){
        ObservableList<Item> CustomerObservableList =Service.getAll();
        tblItem.setItems(CustomerObservableList);
    }

}

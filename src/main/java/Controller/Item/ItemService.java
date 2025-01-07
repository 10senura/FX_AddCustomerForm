package Controller.Item;

import Model.Customer;
import Model.Item;
import javafx.collections.ObservableList;

public interface ItemService {

    boolean AddCustomer(Item item);

    boolean UpdateCustomer(Item item);

    boolean DeleteCustomer(String code);

    Item SearchCustomer(String description);

    ObservableList<Item> getAll();

}

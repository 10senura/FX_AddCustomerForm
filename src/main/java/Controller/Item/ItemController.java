package Controller.Item;

import Model.Item;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController implements ItemService{

    @Override
    public boolean AddItem(Item item) {
        try {
            String sql="INSERT INTO item values (?,?,?,?)";
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement pstm= connection.prepareStatement(sql);
            pstm.setObject(1,item.getCode());
            pstm.setObject(2,item.getDescription());
            pstm.setObject(3,item.getPrice());
            pstm.setDouble(4,item.getQtyOnHand());
            return pstm.executeUpdate()>0;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"ERROR"+e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean UpdateItem(Item item) {
        String sql="UPDATE item SET description=?,unitPrice=?,qtyOnHand=? WHERE code=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,item.getCode());
            pstm.setObject(2,item.getDescription());
            pstm.setObject(3,item.getPrice());
            pstm.setDouble(4,item.getQtyOnHand());
            return pstm.executeUpdate()> 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean DeleteItem(String code) {
        String sql="DELETE FROM item WHERE code='"+code+"'";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            return connection.createStatement().executeUpdate(sql)>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item SearchItem(String description) {
        String sql="SELECT * FROM item WHERE id='"+description+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                return  new Item(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ObservableList<Item> getAll() {
        ObservableList<Item> CustomerObservableList = FXCollections.observableArrayList();
        try {
            String sql="select * from item";

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement PSVM = connection.prepareStatement(sql);
            ResultSet resultSet = PSVM.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("code"));
                System.out.println(resultSet.getString("description"));
                System.out.println(resultSet.getString("unitPrice"));
                System.out.println(resultSet.getString("qtyOnHand"));

                Item item = new Item(
                        resultSet.getString("code"),
                        resultSet.getString("description"),
                        resultSet.getDouble("unitPrice"),
                        resultSet.getInt("qtyOnHand")
                );
                System.out.println(item);
                CustomerObservableList.add(item);
            }
            return CustomerObservableList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

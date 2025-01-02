package db;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    private List<Customer> CustumerList;

    private DBConnection(){
        this.CustumerList= new ArrayList<>();
    }

   public List<Customer> getConnection(){
        return CustumerList;
   }

    public static DBConnection getInstance(){
        if (instance==null){
            return instance= new DBConnection();
        }
        return instance;
    }
}

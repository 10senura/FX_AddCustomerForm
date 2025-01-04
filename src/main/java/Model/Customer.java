package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor

@Data
@NoArgsConstructor

public class Customer {

    private String Id;
    private String Name;
    private String Address;
    private double Salary;

}

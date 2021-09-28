package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class contains the attributes and methods of a employee
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private String dateOfBirth;
    private String password;
    private boolean administrator;
    private ArrayList<QuantitySold> quantitiesSold;


    public Employee(String name, String id, String dateOfBirth, String password, boolean administrator) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.administrator = administrator;
        this.quantitiesSold = new ArrayList<QuantitySold>();
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<QuantitySold> getQuantitiesSold() {
        return quantitiesSold;
    }

    public void addQuantitySold(QuantitySold quantitySold){
        this.quantitiesSold.add(quantitySold);
    }

    @Override
    public String toString() {
        String output;

        output = "name: " + name + "\n" +
                 "id: " + id + "\n" +
                 "date of birth: " + dateOfBirth + "\n" +
                 "password: " + password + "\n";

        return output;
    }
}

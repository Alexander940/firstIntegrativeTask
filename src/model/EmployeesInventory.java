package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * this class contains a list of all employees
 * @author Alexander Echeverry
 * @version 1.0
 */

public class EmployeesInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private ObservableList<Employee> employees;

    public EmployeesInventory() {
        this.employees = FXCollections.observableArrayList();
    }

    /**
     * this method add an employee
     * @param employee contains the employee to add
     * @return if the employee was added return true, in another case this returns false
     */
    public boolean addEmployee(Employee employee){
        this.employees.add(employee);
        boolean successAdd = saveEmployees();

        return successAdd;
    }

    /**
     * this method returns the employees
     * @return this returns an observable list with the employees
     */
    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    /**
     * this method gets the employees of a file
     * @return this returns a observable list with the employees
     */
    private ObservableList<Employee> loadEmployees(){
        try {
            File file = new File("employees.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fis);
            List<Employee> list = (List<Employee>) input.readObject();
            ObservableList<Employee> employees = FXCollections.observableArrayList(list);

            return employees;
        } catch (Exception ex){
            ex.printStackTrace();

            return null;
        }
    }

    /**
     * this save an array list with the employees
     * @return if the array list was successfully saved returns true in another case return false
     */
    private boolean saveEmployees(){
        try{
            File file = new File("employees.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fos);
            output.writeObject(new ArrayList<Employee>(this.employees));
            output.close();

            return true;
        } catch (Exception ex){
            ex.printStackTrace();

            return false;
        }

    }
}

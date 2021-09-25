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
        this.employees = loadEmployees();
    }

    /**
     * this method add an employee
     * @param employee contains the employee to add
     * @return if the employee was added return true, in another case this returns false
     */
    public boolean addEmployee(String name, String id, String birth, String password, boolean administrator){
        Employee employee = new Employee(name, id, birth, password, administrator);
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
     * @return this returns an observable list with the employees
     */
    private ObservableList<Employee> loadEmployees(){
        try {
            File file = new File("src/data/employees.txt");
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
            File file = new File("src/data/employees.txt");
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

    /**
     * This method compare the password and confirm password
     * @param password This is the input of password
     * @param employeeId This is the employee's id for compare password
     * @return This is true if the passwords are equals or false in the another case
     */
    public boolean comparePassword(String password, String employeeId){
        boolean equals = false;
        int passwordEmployeePosition = findEmployeeById(employeeId);

        if(password.equals(employees.get(passwordEmployeePosition).getPassword())){
            equals = true;
        }

        return equals;
    }

    /**
     * This method verify the user to login
     * @param id it contains the employee's id
     * @param inputPassword it contains the employee's password
     * @return it returns true if the user exists and the password and input are equals
     */
    public boolean verificationLogin(String id ,String inputPassword){
        boolean verification = false;

        for(Employee employee: employees){
            if(employee.getId().equals(id)){
                if(employee.getPassword().equals(inputPassword)){
                    verification = true;
                }
            }
        }

        return verification;
    }

    /**
     * This method find an employee by his id
     * @param id this is employee's id
     * @return This is the position of the employee in the observable list (employees)
     */
    private int findEmployeeById(String id){
        int position = -1;
        boolean cent = false;

        for(int i = 0; i < employees.size() && !cent; i++){
            if(employees.get(i).getId().equals(id)){
                position = i;
                cent = true;
            }
        }

        return position;
    }

    /**
     * This method changes the password of an employee
     * @param id This is the employee's id to change password
     * @param password This is the new employee's password
     */
    public void changePassword(String id, String password){

        employees.get(findEmployeeById(id)).setPassword(password);
        saveEmployees();
    }

    public boolean employeeExist(String id){
        boolean res = false;
        int position = findEmployeeById(id);

        if(position != -1){
            res = true;
        }

        return res;
    }
}

package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

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
     * This method add an employee in observable list employees
     * @param name This is employee's name
     * @param id This is employee's id
     * @param birth This is employee's birth
     * @param password This is employee's password
     * @param administrator This is true if the employee is an administrator or false in the other case
     * @return True if the employee was successfully add or false in the other case
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
    public boolean saveEmployees(){
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
<<<<<<< HEAD
        for(Employee employee: employees){
            if(employee.getId().equals(id)){
                if(employee.getPassword().equals(inputPassword)){
                    return true;
                }
            }
        }

        return false;
=======
        int position = findEmployeeByName(id);
        boolean verification = false;
        if(position!=-1){
            if(employees.get(position).getPassword().equals(inputPassword)){

                if(employees.get(position).isAdministrator()==true){

                    return true;

                }else verification= false;

            }else verification = false;

        }else {

            verification = false;
        }
        return  verification;
>>>>>>> bf436b2417f049f59c1a54ffa519e1f3ced740a9
    }

    /**
     * This method find an employee by his id
     * @param id this is employee's id
     * @return This is the position of the employee in the observable list (employees)
     */
    private int findEmployeeById(String id){
        int position = -1;
        boolean cent = false;

        ArrayList<Employee> employeesArr = bubbleMethod();

        for(int i = 0; i < employeesArr.size() && !cent; i++){
            if(employeesArr.get(i).getId().equals(id)){
                position = i;
                cent = true;
            }
        }

        return position;
    }

    public int findEmployeeByName(String name){
        employees = FXCollections.observableArrayList(bubbleMethod());

        int start = 0;
        int end = employees.size()-1;

        while(start<=end){
            int half = (start+end)/2;

            if(employees.get(half).getName().compareTo(name) == 0){
                return half;
            } else if(name.compareTo(employees.get(half).getName()) < 0){
                end = half-1;
            } else if(name.compareTo(employees.get(half).getName()) > 0){
                start = half+1;
            }
        }

        return -1;
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

    /**
     * This method check if an employee exist
     * @param id employee's id to check
     * @return True if the employee is in the observable list employees or false in the other case
     */
    public boolean employeeExist(String id, String name){
        if(!id.equals("")) {
            int position = findEmployeeById(id);

            if (position != -1) {
                return true;
            }
        } else {
            int position = findEmployeeByName(name);

            if(position != -1){
                return true;
            }
        }

        return false;
    }

    /**
     * This method applied the bubble method to sort employees by name
     * @return An array list with the employees sorted
     */
    private ArrayList<Employee> bubbleMethod(){
        ArrayList<Employee> employeesArr = new ArrayList<Employee>(employees);

        Employee auxiliar;
        for (int i = 0; i < employeesArr.size(); i++){
            for(int j = 0; j < employeesArr.size()-1; j++){
                if(employeesArr.get(j).getName().compareTo(employeesArr.get(j+1).getName()) > 0){
                    auxiliar = employeesArr.get(j);
                    employeesArr.set(j, employeesArr.get(j+1));
                    employeesArr.set(j+1, auxiliar);
                }
            }
        }

        return employeesArr;
    }

    /**
     * This method calls the bubble method to organize the observable list employees
     */
    public void sortEmployees(){
        employees = FXCollections.observableArrayList(bubbleMethod());
    }

    /**
     * This method generate menu items to a menu button
     * @return An observable list with the menu items
     */
    public ObservableList<MenuItem> getItems(){
        ObservableList<MenuItem> items = FXCollections.observableArrayList();

        for(Employee employee: employees){
            items.add(new MenuItem(employee.getName()));
        }

        return items;
    }
}

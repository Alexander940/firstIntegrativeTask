package model;

/**
 * This class manage all logic of restaurant
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Restaurant {

    private EmployeesInventory employeesInventory;

    public Restaurant() {
        this.employeesInventory = new EmployeesInventory();
    }

    /**
     * This return the employee's inventory
     * @return this contains the employee's inventory
     */
    public EmployeesInventory getEmployeesInventory() {
        return employeesInventory;
    }

    public void setEmployeesInventory(EmployeesInventory employeesInventory) {
        this.employeesInventory = employeesInventory;
    }
}

package model;

/**
 * This class manage all logic of restaurant
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Restaurant {

    private EmployeesInventory employeesInventory;
    private IngredientsInventory ingredientsInventory;

    public Restaurant() {
        this.employeesInventory = new EmployeesInventory();
        this.ingredientsInventory = new IngredientsInventory();
    }

    /**
     * This return the employee's inventory
     * @return this contains the employee's inventory
     */
    public EmployeesInventory getEmployeesInventory() {
        return employeesInventory;
    }

    /**
     * this method will return an employee's inventory
     * @return this contains the ingredient's inventory
     */
    public IngredientsInventory getIngredientsInventory(){
        return ingredientsInventory;
    }
}

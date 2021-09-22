package model;

/**
 * This class manage all logic of the restaurant
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Restaurant {

    //Singleton

    public static Restaurant instance;

    public static Restaurant getInstance(){
        if(instance == null){
            instance = new Restaurant();
        }
        return instance;
    }

    private EmployeesInventory employeesInventory;
    private IngredientsInventory ingredientsInventory;
    private Menu menu;

    private Restaurant() {
        this.employeesInventory = new EmployeesInventory();
        this.ingredientsInventory = new IngredientsInventory();
        this.menu = new Menu();
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

    public Menu getMenu() {
        return menu;
    }
}

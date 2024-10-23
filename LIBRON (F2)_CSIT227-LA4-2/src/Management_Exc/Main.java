// LIBRON, CHRISTIAN NEIL A.
// F2 - BSCS2
// CSIT 227

package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * Gives a raise from a manager to an employee.
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary) {
        Person foundManager = null;
        Person foundEmployee = null;

        for (Person p : persons) {
            if (p.getName().equals(manager)) {
                foundManager = p;
            }
            if (p.getName().equals(employee)) {
                foundEmployee = p;
            }
        }

        if (foundManager == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if (foundEmployee == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        if (!(foundManager instanceof Manager)) {
            throw new ClassCastException(manager + " is not a manager");
        }
        if (!(foundEmployee instanceof Employee)) {
            throw new ClassCastException(employee + " is not an employee");
        }

        ((Manager) foundManager).giveRaise((Employee) foundEmployee, salary);
    }

    /**
     * Assigns a project manager to a developer.
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Person foundDeveloper = null;
        Person foundManager = null;

        for (Person p : persons) {
            if (p.getName().equals(developer)) {
                foundDeveloper = p;
            }
            if (p.getName().equals(manager)) {
                foundManager = p;
            }
        }

        if (foundDeveloper == null) {
            throw new NoSuchElementException(developer + "does not found");
        }
        if (foundManager == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }

        if (!(foundManager instanceof Manager)) {
            throw new ClassCastException(manager + " is not a manager");
        }
        if (!(foundDeveloper instanceof Developer)) {
            throw new ClassCastException(developer + " is not a Developer");
        }

        ((Developer) foundDeveloper).setProjectManager((Manager) foundManager);
    }

    /**
     * Returns the dialogue of the customer to the employee.
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Person foundCustomer = null;
        Person foundEmployee = null;

        for (Person p : persons) {
            if (p.getName().equals(customer)) {
                foundCustomer = p;
            }
            if (p.getName().equals(employee)) {
                foundEmployee = p;
            }
        }

        if (foundCustomer == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }
        if (foundEmployee == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        if (!(foundCustomer instanceof Customer)) {
            throw new ClassCastException(customer + " is not a customer");
        }
        if (!(foundEmployee instanceof Employee)) {
            throw new ClassCastException(employee + " is not an employee");
        }

        return ((Customer) foundCustomer).speak((Employee) foundEmployee);
    }
}

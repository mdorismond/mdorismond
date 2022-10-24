package com.techelevator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public List<Department> departments = new ArrayList<>();
    public List<Employee> employees = new ArrayList<>();
    public Map<String, Project> projects = new HashMap<>();
    public List<Employee> engineeringEmployees = new ArrayList<>();
    public List<Employee> marketingEmployees = new ArrayList<>();


    private void run() {
        // create some departments
        createDepartments();
        Department marketing = new Department(1, "Marketing");
        Department sales = new Department(2, "Sales");
        Department engineering = new Department(3, "Engineering");

        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);


        // print each department by name
        printDepartments();

        for (Department departmentName : departments) {
            System.out.println(departmentName.getName());
        }

        // create employees
        createEmployees();

         Employee deanJohnson = new Employee();
         deanJohnson.setFirstName("Dean");
         deanJohnson.setLastName("Johnson");
         deanJohnson.setDepartment(engineering);
         deanJohnson.setEmail("djohnson@teams.com");
         deanJohnson.setEmployeeId(1);
         deanJohnson.setHireDate("08/21/2020");
         deanJohnson.setSalary(60000);

         Employee angieSmith = new Employee(2, "Angie", "Smith", "asmith@teams.com", engineering, "08/21/2020");

        Employee margaretThompson = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", marketing, "08/21/2020");

        employees.add(deanJohnson);
        employees.add(angieSmith);
        employees.add(margaretThompson);

        // give Angie a 10% raise, she is doing a great job!

        angieSmith.raiseSalary(10);

        // print all employees
        printEmployees();

//        for (Employee employeeName : employees) {
//            System.out.println(employeeName.getFullName() + " ($" + employeeName.getSalary() + ") " + employeeName.getDepartment().getName());
//        }

        for (Employee employeeName : employees) {
            NumberFormat currency = NumberFormat.getCurrencyInstance();

            System.out.println(employeeName.getFullName() + " (" + currency.format(employeeName.getSalary()) + ") " + employeeName.getDepartment().getName());
        }



        // create the TEams project
        createTeamsProject();

        for (Employee employee : employees) {
            if (employee.getDepartment().equals(engineering)) {
                engineeringEmployees.add(employee);
            }
        }

        Project teams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        teams.setTeamMembers(engineeringEmployees);

        projects.put("TEams", teams);



        // create the Marketing Landing Page Project
        createLandingPageProject();

        for (Employee employee : employees) {
            if (employee.getDepartment().equals(marketing)) {
                marketingEmployees.add(employee);
            }
        }

        Project landingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");

        landingPage.setTeamMembers(marketingEmployees);

        projects.put("Marketing Landing Page", landingPage);




        // print each project name and the total number of employees on the project
        printProjectsReport();

        String[] projectsKeys = projects.keySet().toArray(new String[projects.size()]);


        for (String projectGroup : projectsKeys) {
            System.out.println(projectGroup + ": " + projects.get(projectGroup).getTeamMembers().size());
        }


    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");

    }

}

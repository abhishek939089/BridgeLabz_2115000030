import java.util.ArrayList;
import java.util.List;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    List<Employee> employees;

    Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    void addEmployee(Employee emp) {
        employees.add(emp);
    }

    void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            System.out.println("Employee: " + emp.name);
        }
    }
}

class Company {
    String name;
    List<Department> departments;

    Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void displayDepartments() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
        }
    }
}

public class CompanyManagement {
    public static void main(String[] args) {
        Company company = new Company("Tech Corp");
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        dept1.addEmployee(new Employee("Abhishek"));
        dept1.addEmployee(new Employee("Rahul"));

        dept2.addEmployee(new Employee("Saif"));

        company.addDepartment(dept1);
        company.addDepartment(dept2);

        company.displayDepartments();
    }
}

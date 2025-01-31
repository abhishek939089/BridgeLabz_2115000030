class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }

    public static void main(String[] args) {
        Manager manager = new Manager(101, "HR", 80000.00);
        manager.displayEmployeeDetails();
        manager.displayManagerDetails();
    }
}

class Manager extends Employee {
    String officeNumber;

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
        this.officeNumber = "B-102";
    }

    void displayManagerDetails() {
        System.out.println("Office Number: " + officeNumber);
    }
}

class Employee {
    static String companyName = "Tech Corp";
    static int totalEmployees = 0;
    final int id;
    String name, designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 1, "Software Engineer");
        Employee emp2 = new Employee("Bob", 2, "Manager");
        emp1.displayDetails();
        emp2.displayDetails();
        displayTotalEmployees();
    }
}

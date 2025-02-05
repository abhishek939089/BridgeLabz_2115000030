import java.util.ArrayList;
import java.util.List;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments;
    List<Faculty> faculties;

    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        University university = new University("GLA");

        university.addDepartment(new Department("Engineering"));
        university.addDepartment(new Department("Science"));

        university.addFaculty(new Faculty("Dr. Smith"));
        university.addFaculty(new Faculty("Dr. Johnson"));
    }
}

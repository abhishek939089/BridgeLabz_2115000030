import java.util.ArrayList;
import java.util.List;

class Course {
    String name;

    Course(String name) {
        this.name = name;
    }
}

class Student {
    String name;
    List<Course> courses;

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void enrollCourse(Course course) {
        courses.add(course);
    }

    void displayCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}

class School {
    String name;
    List<Student> students;

    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }
}

public class SchoolManagement {
    public static void main(String[] args) {
        School school = new School("Gla University");
        Student s1 = new Student("Abhishek");
        Student s2 = new Student("Arun");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        school.addStudent(s1);
        school.addStudent(s2);

        s1.displayCourses();
        s2.displayCourses();
    }
}

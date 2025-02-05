import java.util.ArrayList;
import java.util.List;

class Course {
    String name;
    Professor professor;
    List<Student> students;

    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.name + " is assigned to teach " + name);
    }

    void enrollStudent(Student student) {
        students.add(student);
        System.out.println(student.name + " enrolled in " + name);
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
        course.enrollStudent(this);
    }
}

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

public class UniversityManagement2 {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Computer Science");

        course1.assignProfessor(prof1);
        course2.assignProfessor(prof2);

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);
    }
}

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

class Course<T extends CourseType> {
    private T courseType;
    private String department;
    private int credits;

    public Course(T courseType, String department, int credits) {
        this.courseType = courseType;
        this.department = department;
        this.credits = credits;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public int getCredits() {
        return credits;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseType.getCourseName() + " | Department: " + department +
                " | Credits: " + credits + " | Evaluation: " + courseType.getEvaluationMethod());
    }
}

class University {
    private List<Course<?>> courses = new ArrayList<>();

    public void addCourse(Course<?> course) {
        courses.add(course);
    }

    public void displayAllCourses() {
        for (Course<?> course : courses) {
            course.displayCourseInfo();
        }
    }
}

class CourseUtility {
    public static void displayCourseDetails(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Evaluation: " + course.getEvaluationMethod());
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>(new ExamCourse("Advanced Mathematics"), "Science", 4);
        Course<AssignmentCourse> history = new Course<>(new AssignmentCourse("World History"), "Arts", 3);
        Course<ResearchCourse> aiResearch = new Course<>(new ResearchCourse("AI Research"), "Computer Science", 5);

        University university = new University();
        university.addCourse(math);
        university.addCourse(history);
        university.addCourse(aiResearch);

        System.out.println("University Course List:");
        university.displayAllCourses();
    }
}

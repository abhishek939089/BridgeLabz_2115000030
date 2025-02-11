class Student {
    int rollNumber, age;
    String name, grade;
    Student next;

    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentRecord {
    Student head;

    void addStudent(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    void deleteStudent(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    Student searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null && temp.rollNumber != rollNumber) temp = temp.next;
        return temp;
    }

    void updateGrade(int rollNumber, String newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) student.grade = newGrade;
    }

    void displayStudents() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecord record = new StudentRecord();
        record.addStudent(101, "Alice", 20, "A");
        record.addStudent(102, "Bob", 22, "B");
        record.displayStudents();
        record.updateGrade(101, "A+");
        record.deleteStudent(102);
        record.displayStudents();
    }
}

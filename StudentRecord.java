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

    void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position <= 1) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            addStudentAtEnd(rollNumber, name, age, grade);
        } else {
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    void deleteStudent(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    Student searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
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
        record.addStudentAtBeginning(101, "Alice", 20, "A");
        record.addStudentAtEnd(102, "Bob", 22, "B");
        record.addStudentAtPosition(103, "Charlie", 21, "C", 2);
        record.displayStudents();
        record.updateGrade(101, "A+");
        record.deleteStudent(102);
        record.displayStudents();
    }
}

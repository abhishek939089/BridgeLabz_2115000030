import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "student_data.dat";
        
        writeStudentData(fileName);

        readStudentData(fileName);
    }

    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice Johnson");
            dos.writeDouble(3.85);
            
            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.72);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    private static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    abstract double calculateBill();
}

class InPatient extends Patient {
    private double dailyCharge;
    private int daysAdmitted;

    InPatient(int patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }

    double calculateBill() {
        return dailyCharge * daysAdmitted;
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient patient = new InPatient(301, "Rahul", 30, 5000, 5);
        System.out.println("Total Bill: " + patient.calculateBill());
    }
}

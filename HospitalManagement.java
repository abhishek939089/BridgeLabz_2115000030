import java.util.ArrayList;
import java.util.List;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    List<Patient> patients;

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " is consulting " + patient.name);
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;

    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doc1 = new Doctor("Smith");
        Doctor doc2 = new Doctor("Brown");

        Patient pat1 = new Patient("Alice");
        Patient pat2 = new Patient("Bob");

        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(pat1);
        hospital.addPatient(pat2);

        doc1.consult(pat1);
        doc1.consult(pat2);
        doc2.consult(pat1);
    }
}

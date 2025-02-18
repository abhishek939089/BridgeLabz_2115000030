import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    abstract String getRequiredSkills();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRequiredSkills() {
        return "Java, Python, Data Structures, Algorithms";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRequiredSkills() {
        return "Python, Machine Learning, Statistics, SQL";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRequiredSkills() {
        return "Market Research, Agile, Communication, Leadership";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;
    private List<String> skills;

    public Resume(T jobRole, List<String> skills) {
        this.jobRole = jobRole;
        this.skills = skills;
    }

    public boolean isEligible() {
        for (String skill : jobRole.getRequiredSkills().split(", ")) {
            if (!skills.contains(skill)) {
                return false;
            }
        }
        return jobRole.getExperienceYears() >= 2;
    }

    public void displayResume() {
        System.out.println("Candidate: " + jobRole.getCandidateName());
        System.out.println("Experience: " + jobRole.getExperienceYears() + " years");
        System.out.println("Applied Role: " + jobRole.getClass().getSimpleName());
        System.out.println("Skills: " + skills);
        System.out.println("Eligibility: " + (isEligible() ? "Shortlisted ✅" : "Rejected ❌"));
    }
}

class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Processing: " + role.getCandidateName() + " for " + role.getClass().getSimpleName());
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Abhishek Sharma", 3),
                List.of("Java", "Python", "Data Structures", "Algorithms"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Abhishek Bhagel", 1),
                List.of("Python", "Machine Learning", "Statistics"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Abhishek Adjariya", 5),
                List.of("Market Research", "Agile", "Communication", "Leadership"));

        System.out.println("AI-Driven Resume Screening Results:");
        seResume.displayResume();
        System.out.println();
        dsResume.displayResume();
        System.out.println();
        pmResume.displayResume();

        System.out.println("\nProcessing All Candidates:");
        List<JobRole> applicants = List.of(
                new SoftwareEngineer("Abhishek Sharma", 3),
                new DataScientist("Abhishek Bhagel", 1),
                new ProductManager("Abhishek Adjariya", 5)
        );

        ResumeProcessor.processResumes(applicants);
    }
}

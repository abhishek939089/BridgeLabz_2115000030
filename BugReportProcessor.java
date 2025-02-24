import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
    String reportedBy();
}

class SoftwareModule {
    @BugReport(description = "Null pointer exception in edge cases", reportedBy = "Alice")
    @BugReport(description = "Performance issue when processing large data", reportedBy = "Bob")
    public void process() {
        System.out.println("Processing data...");
    }
}

public class BugReportProcessor {
    public static void main(String[] args) throws Exception {
        SoftwareModule module = new SoftwareModule();
        Method method = module.getClass().getMethod("process");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description() + ", Reported By: " + bug.reportedBy());
            }
        }

        module.process();
    }
}

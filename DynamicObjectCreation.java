class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public String getName() {
        return name;
    }
}

class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Student student = (Student) obj;

        System.out.println("Student Name: " + student.getName());
    }
}

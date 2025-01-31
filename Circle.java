class Circle {
    double radius;

    Circle() {
        this(2.5);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);

        System.out.println("Circle 1 Radius: " + circle1.radius);
        System.out.println("Circle 2 Radius: " + circle2.radius);
    }
}

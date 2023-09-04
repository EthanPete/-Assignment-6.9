public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    // Constructors
    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter and setter methods for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Calculate and return the area of the circle
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Calculate and return the perimeter (circumference) of the circle
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Compare two circles based on their radii
    @Override
    public int compareTo(Circle other) {
        if (this.radius < other.radius) {
            return -1;
        } else if (this.radius > other.radius) {
            return 1;
        } else {
            return 0;
        }
    }

    // Check if two circles are equal based on their radii
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Circle other = (Circle) obj;
        return Double.compare(other.radius, radius) == 0;
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(3.0);

        System.out.println("Circle 1 Radius: " + circle1.getRadius());
        System.out.println("Circle 1 Area: " + circle1.getArea());
        System.out.println("Circle 1 Perimeter: " + circle1.getPerimeter());

        System.out.println("Circle 2 Radius: " + circle2.getRadius());
        System.out.println("Circle 2 Area: " + circle2.getArea());
        System.out.println("Circle 2 Perimeter: " + circle2.getPerimeter());

        // Compare circles based on their radii
        int comparisonResult = circle1.compareTo(circle2);
        if (comparisonResult < 0) {
            System.out.println("Circle 1 is smaller than Circle 2");
        } else if (comparisonResult > 0) {
            System.out.println("Circle 1 is larger than Circle 2");
        } else {
            System.out.println("Circle 1 and Circle 2 have the same radius");
        }

        // Check if two circles are equal
        if (circle1.equals(circle2)) {
            System.out.println("Circle 1 and Circle 2 are equal");
        } else {
            System.out.println("Circle 1 and Circle 2 are not equal");
        }
    }
}

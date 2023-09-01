import java.util.Scanner;

// GeometricObject class represents a geometric object with color and fill properties
class GeometricObject {
    private String color;
    private boolean filled;

    // Default constructor sets color to "white" and filled to false
    public GeometricObject() {
        this.color = "white";
        this.filled = false;
    }

    // Parameterized constructor allows setting color and fill properties
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    // Getter for filled
    public boolean isFilled() {
        return filled;
    }

    // Setter for filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // String representation of the object, including color and fill properties
    @Override
    public String toString() {
        return "Color: " + color + "\nFilled: " + filled;
    }
}

// Triangle class extends GeometricObject and represents a triangle
class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    // Default constructor creates an equilateral triangle with sides of length 1.0
    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    // Parameterized constructor allows setting the lengths of the triangle's sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getter for side1
    public double getSide1() {
        return side1;
    }

    // Getter for side2
    public double getSide2() {
        return side2;
    }

    // Getter for side3
    public double getSide3() {
        return side3;
    }

    // Calculate and return the area of the triangle using Heron's formula
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Calculate and return the perimeter (sum of sides) of the triangle
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // String representation of the triangle, including side lengths and inherited color/fill properties
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3 + "\n" + super.toString();
    }
}

// TestTriangle class contains the main method to test the Triangle class
public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the three sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        System.out.print("Enter the color of the triangle: ");
        String color = input.next();

        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();

        // Create a Triangle object with user-provided input
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Display information about the triangle
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());

        input.close();
    }
}


UML:
------------------------------------
|         GeometricObject         |
------------------------------------
| - color: String                 |
| - filled: boolean               |
------------------------------------
| + GeometricObject()             |
| + GeometricObject(color: String,|
|       filled: boolean)          |
| + getColor(): String            |
| + setColor(color: String): void |
| + isFilled(): boolean           |
| + setFilled(filled: boolean):   |
|       void                      |
| + toString(): String           |
------------------------------------

------------------------------------
|            Triangle             |
------------------------------------
| - side1: double                 |
| - side2: double                 |
| - side3: double                 |
------------------------------------
| + Triangle()                    |
| + Triangle(side1: double,      |
|       side2: double,            |
|       side3: double)            |
| + getSide1(): double           |
| + getSide2(): double           |
| + getSide3(): double           |
| + getArea(): double            |
| + getPerimeter(): double       |
| + toString(): String           |
------------------------------------

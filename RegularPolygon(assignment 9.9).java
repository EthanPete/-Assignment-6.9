public class RegularPolygon {
 private int n = 3;
 private double side = 1;
 private double x = 0;
 private double y = 0;

 public RegularPolygon() {
 }

  // Constructor with specified number of sides and side length
 public RegularPolygon(int n, double side) {
  this.n = n;
  this.side = side;
 }

 // Constructor with specified number of sides, side length, and center coordinates
 public RegularPolygon(int n, double side, double x, double y) {
  this.n = n;
  this.side = side;
  this.x = x;
  this.y = y;
 }

  // Accessor method for number of sides
 public int getN() {
  return n;
 }

  // Mutator method for number of sides
 public void setN(int n) {
  this.n = n;
 }

  // Accessor method for side length
 public double getSide() {
  return side;
 }

 // Mutator method for side length
 public void setSide(double side) {
  this.side = side;
 }

 // Accessor method for x-coordinate of center
 public double getX() {
  return x;
 }

  // Mutator method for x-coordinate of center
 public void setX(double x) {
  this.x = x;
 }

  // Accessor method for y-coordinate of center
 public double getY() {
  return y;
 }

 // Mutator method for y-coordinate of center
 public void setY(double y) {
  this.y = y;
 }

  // Method to calculate and return the perimeter of the polygon
 public double getPerimeter() {
  return n * side;
 }

 // Method to calculate and return the area of the polygon
 public double getArea() {
  return (n * side * side) / (4 * Math.tan(Math.PI / n));
 }

 public static void main(String[] args) {
  // Create three instances of RegularPolygon using different constructors
  RegularPolygon polygon1 = new RegularPolygon();
  RegularPolygon polygon2 = new RegularPolygon(6, 4);
  RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

   // Display the properties of each polygon
  System.out.println("Polygon 1 - Perimeter: " + polygon1.getPerimeter() + ", Area: " + polygon1.getArea());
  System.out.println("Polygon 2 - Perimeter: " + polygon2.getPerimeter() + ", Area: " + polygon2.getArea());
  System.out.println("Polygon 3 - Perimeter: " + polygon3.getPerimeter() + ", Area: " + polygon3.getArea());
 }
}

UML:
-------------------------------------
|     RegularPolygon                |
-------------------------------------
| - n: int                          |
| - side: double                    |
| - x: double                       |
| - y: double                       |
-------------------------------------
| + RegularPolygon()                |
| + RegularPolygon(n: int, side: double) |
| + RegularPolygon(n: int, side: double, x: double, y: double) |
| + getN(): int                     |
| + setN(n: int): void              |
| + getSide(): double               |
| + setSide(side: double): void     |
| + getX(): double                  |
| + setX(x: double): void           |
| + getY(): double                  |
| + setY(y: double): void           |
| + getPerimeter(): double          |
| + getArea(): double               |
-------------------------------------

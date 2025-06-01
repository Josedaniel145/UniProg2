package shapeStorage;

public class Circle extends Shape {
	private double radius;
	public Circle(double radius) {
		if(radius <=0) {
			throw new
			IllegalArgumentException("Radius must be positive");
		}
		this.radius = radius; 
	}
	public double getRadius() {
		return radius; 
	}
	@Override 
	public double getArea() {
		return Math.PI * radius * radius; 
	}
	@Override 
	public String toString() {
		return String.format("Circle: radius=%.2f", radius); // The format specifier %.2f will format 3.0 as "3.00" 
	}
	
	
	

}

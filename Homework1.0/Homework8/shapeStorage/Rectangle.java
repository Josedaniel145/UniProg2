package shapeStorage;

public class Rectangle extends Shape{
	private double width;
	private double length;
	
	public Rectangle(double width, double length) {
		if(width <=0 || length <=0) {
			throw new IllegalArgumentException("Width and length must be positive.");
		}
		this.width = width;
		this.length = length; 
	}
	
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length; 
	}
	
	@Override
	public double getArea() {
		return width * length;
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle: width=%.2f, length=%.2f", this.width, this.length);
	}

}

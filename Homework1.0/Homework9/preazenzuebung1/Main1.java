package preazenzuebung1;

public class Main1 {
	public static void main(String[] args) {
		Circle diameter = (r) -> {
			if (r <= 0) {
				return 0.0;
			}
			return 2 * r;
		};
		Circle surface = (r) -> {
			if (r <= 0) {
				return Math.PI * r * r;
			}
			return Math.PI * r * r;
		};
		Circle circumference = (r) -> {
			if (r <= 0) {
				return 0.0;
			}
			return 2 * Math.PI * r;
		};
		double testRadius = 3;
		System.out.println("Diameter: " + diameter.calculate(testRadius) );
		System.out.println("Surface: " + surface.calculate(testRadius) );
		System.out.println("Circumference: " + circumference.calculate(testRadius) );

	} 

}

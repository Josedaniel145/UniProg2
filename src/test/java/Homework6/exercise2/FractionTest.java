package Homework6.exercise2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
	
	@Test
	void testConstructorAndGetters() {
		Fraction f = new Fraction(3,4);
		assertEquals(3, f.getZaehler(), "Numerator should be 3");
		assertEquals(4, f.getNenner(), "Numerator should be 4");

		
	}
	
}




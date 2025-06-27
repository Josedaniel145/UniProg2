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
	@Test 
	
	void testKehrwert() {
		Fraction f = new Fraction(2,3); 
		f.Kehrwert();
		assertEquals(3, f.getZaehler(), "Kehrwert: Numerator should be 3 for original 2/3");
		assertEquals(2, f.getNenner(),"Kehrwert: Denominator should be 2 for original 2/3" );
	}
	
	@Test
	void testMultiplikation() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,3);
		
		f1.multiplikation(f2);
		assertEquals(2, f1.getZaehler(), "Multiplikation: Numerator should be 1*2=2");
		assertEquals(6, f1.getZaehler(), "Multiplikation: Denominator should be 2*3=6");

	}
	
	@Test
	void testAddition() {
		Fraction f1 = new Fraction (1,2);
		Fraction f2 = new Fraction (2,3);
		 f1.addition(f2);
		 assertEquals(10, f1.getZaehler(), "Addition: Numerator should be 4+6= 10");
		 assertEquals(6, f1.getNenner(), "Addition: Denominator should be 3*2= 6");

	}
	
	@Test
	void testKuerzen() {
		Fraction f = new Fraction(6,9);
		f.kuerzen();
		assertEquals(2, f.getZaehler(), "Kuerzen: Numerator of 6/9 should become 2");
		assertEquals(3, f.getNenner(), "Kuerzen: Numerator of 6/9 should become 3");
		
	}
	
}




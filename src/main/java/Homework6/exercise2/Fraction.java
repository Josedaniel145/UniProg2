package Homework6.exercise2;

public class Fraction {
	private int zaehler;
	private int nenner;

	// icomplete
	public Fraction(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
	}

	// wrong
	public void Kehrwert() {
		this.setNenner(this.zaehler);
		this.setZaehler(this.nenner);
	}
	/* 
	 * public void Kehrwert(){
	 *  	if(this.zaehler==0){
	 *  throw new ArithmeticException("Cannot take reciprocal of a fraction with zero numerator (results in zero denominator).");}
	 *  int tempZahealer = this.zaehler;
	 *  this.zaehler = this.nenner;
	 *  this.nenner = tempZaehler; 
	 *  }
	 * 
	 * 
	 * 
	 * 
	 * */

	// wrong
	public void multiplikation(Fraction a) {
		this.setNenner(this.nenner * nenner);
		this.setZaehler(this.zaehler * zaehler);
	}
	
	/* public void multiplikation(Fraction a) {
	 *   this.zaehler = this.zaehler * a.getZaehler();
	 *    this.nenner = this.nenner * a.getNenner();
	 *    if (this.nenner == 0) {
     *  throw new ArithmeticException("Multiplication resulted in a zero denominator.");
     *  }
     *    } */
	

	// wrong
	public void addition(Fraction a) {
		if (a.getNenner() != this.getNenner()) {
			int neuerZaehler;
			this.setZaehler(this.getZaehler() * a.getNenner());
			neuerZaehler = a.getZaehler() * this.getNenner();
			this.setZaehler(this.getZaehler() + neuerZaehler);
			/*
			 * 
			 * this.nenner = this.nenner * a.getNenner();
			 * 
			 *  
			 *  */
		} else {
			this.setZaehler(this.getZaehler() + a.getZaehler());
		}
	}

	// wrong
	public void kuerzen() {
		int ggt = ggt(Math.abs(zaehler), Math.abs(nenner));
		this.zaehler *= ggt;
		this.nenner *= ggt;
	}
	
	/* 
	 * public void kuerzen(){
	 * if(this.nenner == 0){
	 * throw new ArithmeticException("Cannot simplify a fraction with zero denominator.");}
	 * if(this.zaehler == 0) {
	 * this.nenner = 1;
	 * return;
	 * }
	 * int commonDivisor = ggt(Math.abs(this.zaehler), Math.abs(this.nenner));
	 * 
	 * if(commonDivisor !=0){
	 * this.zaehler /= commonDivisor;
	 * this.nenner /= commonDivisor;
	 * }
	 * 
	 * if(this.nenner < 0) {
	 * this.zaehler *= -1;
	 * this.nenner *= -1;
	 * }
	 * 
	 * 
	 * }
	 */

	// helper method Euklidian algorithm ,
	// here are no mistakes
	private int ggt(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	@Override
	public String toString() {
		return this.getZaehler() + "/" + this.getNenner();
	}

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		this.nenner = nenner;
	}

}

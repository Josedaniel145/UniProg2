package exercise1;

public class Milk extends PopularGrocery {
	public Milk(int quantity, int discountThreshold, int popularityLevel) {
		super(popularityLevel);
		this.discountThreshold = discountThreshold;
		this.quantity = quantity;
		this.householdLimit = 20; 
	}
	
	public int getBulkDiscount() {
		if(quantity >= discountThreshold) {
			return 20;
		} else {
			return 0;
		}
	}

}

package exercise1;

public abstract class PopularGrocery extends GroceryItem {
	int popularityLevel;
	int quantity;

	public PopularGrocery(int popularityLevel) {
		this.isPopular = true;
		this.popularityLevel = popularityLevel;
	}

	public boolean showWarning() {
		if (quantity > householdLimit) { // Corrected spelling
			return true;
		} else {
			return false; // Return false if the condition is not met
		}
	}

	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;

	}

}

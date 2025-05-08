package exercise1;

public class Profile {
	private ShippingInfo shippingInfo;
	
	public Profile(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo; 
	}
	
	/*public String getShippingCityFromInfo() {
        // Check if shippingInfo actually exists to avoid errors
        if (this.shippingInfo != null) {
            // Ask our own shippingInfo object for its city
            return this.shippingInfo.getCity();
        }
        // If there's no shippingInfo, return a default or indicate an error
        return "N/A (No Shipping Info)";
    } */

}

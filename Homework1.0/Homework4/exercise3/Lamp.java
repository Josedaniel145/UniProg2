package exercise3;

public class Lamp implements Switchable, Dimmable {
	private boolean on;
	private int brightness;
	
	public Lamp () {
		this.on = false;
		this.brightness = 0;
	}
	
	@Override
	public void turnOn() {
		this.on =true;
		System.out.print("Lamo turned ON");
		if(this.brightness == 0) {
			this.brightness = MAX_BRIGHTNESS /2;
		}
		
	}
	
	public void turnOff() {
		this.on = false;
		System.out.println("Lamp turnedOFF");
	}
	
	public boolean isOn() {
		return this.on;
	}
	
	@Override
	
	public void setBrightness(int level) {
		if(this.on) {
			if(level <0) {
				this.brightness = 0;
				
			} else if (level > MAX_BRIGHTNESS) {
				this.brightness = MAX_BRIGHTNESS;
			} else {
				this.brightness = level;
			}
			System.out.println("Lamp brightness set to " + this.brightness );
			
		} else {
			System.out.println("Cannot set brightness, lamp is OFF");
		}
	}
	
	@Override 
	public int getBrightness() {
		if(!this.on) {
			return 0;
		}
		return this.brightness;
	}
	
	public void dimToHalf() {
		if(this.on) {
			setBrightness(MAX_BRIGHTNESS / 2);
		} else {
			System.out.println("Cannot dim, lamp is OFF");
		}
	}

}


public class JsonBean { 
	
	String loc;
	
	String city;
	String device;
	String count;
	public JsonBean(String count, String loc, String city, String device) {
		super();
		this.count = count;
		this.loc = loc;
		this.city = city;
		this.device = device;
	}
	
	public JsonBean() {
		super();
		
	}
	
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
	

}

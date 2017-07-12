package earth;

public class Student {
	
	private String name;
	private Geolocation position;
	
	public Student(String name, double latitude, double longitude) {
		this.name = name;
		position = new Geolocation(latitude, longitude);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Geolocation getPosition() {
		return position;
	}
	
	public void setPosition(Geolocation position) {
		this.position = position;
	}
	
}

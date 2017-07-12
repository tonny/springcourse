package earth;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	
	private String name;
	private Geolocation geolocation;
	private int dimention = 20;
	private List<Geolocation> squarePoints;
	
	public ClassRoom(String name, double latitude, double longitude) {
		this.name = name;
		geolocation = new Geolocation(latitude,longitude);
		squarePoints = new ArrayList<Geolocation>();
		fillSquerePoints();
	}
	
	/**
	 * Function to calculate the geolocation points (North-East, South-East, South-West,
	 * North-West) in base a geolocation point in the earth where is create a classroom 
	 * with dimension NxN. 
	 * Then the classroom know their points in the earth wich represent a square. 
	 */
	private void fillSquerePoints() {
		double meters = dimention/2;
		// 1 degree in google map is equal to 111.32 Kilometer. 1Degree = 111.32KM. 
		// 1KM in Degree = 1 / 111.32 = 0.008983. 1M in Degree = 0.000008983
		// 0.0000089 ~= coefficient of variation
		double coef = meters * 0.0000089; 
		double divLat = Math.cos(geolocation.getLatitude() * 0.018); // pi/180 ~= 0.018 

		Geolocation ne = new Geolocation(geolocation.getLatitude() + coef,
				                         geolocation.getLongitude() + coef/divLat);
		Geolocation se = new Geolocation(geolocation.getLatitude() - coef,
				                         geolocation.getLongitude() + coef/divLat);
		Geolocation sw = new Geolocation(geolocation.getLatitude() - coef,
				                         geolocation.getLongitude() - coef/divLat);
		Geolocation nw = new Geolocation(geolocation.getLatitude() + coef,
				                         geolocation.getLongitude() - coef/divLat);
		squarePoints.add(ne);
		squarePoints.add(se);
		squarePoints.add(sw);
		squarePoints.add(nw);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Geolocation getGeolocation() {
		return geolocation;
	}
	
	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}
	/**
	 * Algorithm using the 'haversine' formula to calculate the distance between two
	 * latitude/longitude points
	 * @see https://en.wikipedia.org/wiki/Haversine_formula
	 * @see http://www.movable-type.co.uk/scripts/latlong.html
	 * @param p1 Geolocation that contain latitude/longitude
	 * @param p2 Geolocation that contain latitude/longitude
	 * @return return the distance in meters
	 */
	public double calculatePoint(Geolocation p1, Geolocation p2) {
		int r = 6378137; // Earth’s mean radius in meter                                                                                           
		double dLat = rad(p2.getLatitude() - p1.getLatitude());                                                                                                           
		double dLong = rad(p2.getLongitude() - p1.getLongitude());                                                                                                          
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + 
	    		   Math.cos(rad(p1.getLatitude()) * Math.cos(rad(p2.getLatitude()))) *                                                                                    
			       Math.sin(dLong / 2) * Math.sin(dLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = r * c;
		return d; // returns the distance in meters                                                                                                   
	}
	
	/** 
	 * @param x represent a difference between latA - latB or longA - longB 
	 * @return a value in radians
	 */
	 private double rad (double x) {                                                                                                                        
		 return x * (Math.PI / 180);                                                                                                                  
	 };
	 
	 /**
	  * Function to verify if a geolocation point is inside of any polygon,
	  * This algorithm is bases point in polygon (PIP) used in computer graphics
	  * @see https://en.wikipedia.org/wiki/Point_in_polygon
	  * @see https://wrf.ecse.rpi.edu//Research/Short_Notes/pnpoly.html 
	  * @param geo is a object that has a latitude and longitude
	  * @return if the student is inside a course in base his geolocation 
	  */
	 public boolean isStudentInClassRoom (Geolocation geo) {
		 boolean inside = false;
		 double x = geo.getLatitude();
		 double y = geo.getLongitude();
		 for (int i = 0, j = squarePoints.size() - 1; i < squarePoints.size(); j = i++) {
		        double xi = squarePoints.get(i).getLatitude(); 
		        double yi = squarePoints.get(i).getLongitude();
		        double xj = squarePoints.get(j).getLatitude(); 
		        double yj = squarePoints.get(j).getLongitude();
		        
		        boolean intersect = ((yi > y) != (yj > y)) && (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
		        if (intersect) inside = !inside;
		}
		return inside;
	 }
	 
	 public void printSquarePoints() {
		 for(Geolocation g:squarePoints) {
			 System.out.println(g.getLatitude()+","+g.getLongitude());
		 }
	 }
	 
	 public void printDistances() {
		 for(Geolocation g:squarePoints) {
			 System.out.println(calculatePoint(geolocation,g));
		 }
	 }
}

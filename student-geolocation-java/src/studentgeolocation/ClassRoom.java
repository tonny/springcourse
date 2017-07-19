package studentgeolocation;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	private String name;
	private Geolocation geolocation;
	private final int dimention = 20;
	private List<Geolocation> squarePoints;
	private SquareUtil squareUtil = new SquareUtil();

	public ClassRoom(String name, double latitude, double longitude) {
		this.name = name;
		geolocation = new Geolocation(latitude, longitude);
		squarePoints = new ArrayList<Geolocation>();
		fillSquerePoints();
	}

	/**
	 * Function to calculate the geolocation points (North-East, South-East,
	 * South-West, North-West) in base a geolocation point in the earth where is
	 * create a classroom with dimension NxN. Then the classroom know their points
	 * in the earth which represent a square. Additional information about convert
	 * 1 degree in meters: 1 degree in google map is equal to 111.32 Kilometer. 
	 * 1 Degree = 111.32KM. 1KM in Degree = 1 / 111.32 = 0.008983. 
	 * 1M in Degree = 0.000008983. 0.0000089 ~= coefficient of variation
	 */
	private void fillSquerePoints() {
		double meters = dimention / 2;
		double coefficientVariation = 0.0000089;
		double coef = meters * coefficientVariation;
		double divLat = Math.cos(Math.toRadians(geolocation.getLatitude()));

		Geolocation northEast = new Geolocation(geolocation.getLatitude() + coef,
				geolocation.getLongitude() + coef / divLat);
		Geolocation southEast = new Geolocation(geolocation.getLatitude() - coef,
				geolocation.getLongitude() + coef / divLat);
		Geolocation southWest = new Geolocation(geolocation.getLatitude() - coef,
				geolocation.getLongitude() - coef / divLat);
		Geolocation northWest = new Geolocation(geolocation.getLatitude() + coef,
				geolocation.getLongitude() - coef / divLat);

		squarePoints.add(northEast);
		squarePoints.add(southEast);
		squarePoints.add(southWest);
		squarePoints.add(northWest);
	}

	public String getName() {
		return name;
	}

	public Geolocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}

	/**
	 * Function to verify if a geolocation point is inside of any polygon, This
	 * algorithm is bases point in polygon (PIP) used in computer graphics.
	 * 
	 * @see       <a href="https://en.wikipedia.org/wiki/Point_in_polygon">
	 *            Point in Polygon Algorithm</a>
	 * @see       <a href="https://wrf.ecse.rpi.edu//Research/Short_Notes/pnpoly.html">
	 * 			  Short notes to implementation Point in Polygon 
	 *            </a>
	 * @param geo Is a Geolocation object that has a latitude and longitude which represent 
	 *            student position.
	 * @return    <code>true</code> if the student is inside a course in base his geolocation
	 */
	public boolean isStudentInClassRoom(Geolocation geo) {
		boolean inside = false;
		double x = geo.getLatitude();
		double y = geo.getLongitude();
		for (int i = 0, j = squarePoints.size() - 1; i < squarePoints.size(); j = i++) {
			double xi = squarePoints.get(i).getLatitude();
			double yi = squarePoints.get(i).getLongitude();
			double xj = squarePoints.get(j).getLatitude();
			double yj = squarePoints.get(j).getLongitude();

			boolean intersect = ((yi > y) != (yj > y)) && (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
			if (intersect)
				inside = !inside;
		}
		return inside;
	}

	public void printSquarePoints() {
		squareUtil.printSquarePoints(squarePoints);
	}

	public void printDistances() {
		squareUtil.printDistances(squarePoints, geolocation);
	}
}
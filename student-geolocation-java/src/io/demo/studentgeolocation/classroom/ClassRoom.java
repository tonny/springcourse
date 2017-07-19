package io.demo.studentgeolocation.classroom;

import java.util.ArrayList;
import java.util.List;

import io.demo.studentgeolocation.common.Geolocation;

public class ClassRoom {

	private String name;
	private Geolocation geolocation;
	private final int dimention = 20;
	private List<Geolocation> squarePoints;

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
	 * in the earth wich represent a square.
	 */
	private void fillSquerePoints() {
		double meters = dimention / 2;
		// 1 degree in google map is equal to 111.32 Kilometer. 1Degree = 111.32KM.
		// 1KM in Degree = 1 / 111.32 = 0.008983. 1M in Degree = 0.000008983
		// 0.0000089 ~= coefficient of variation
		double coefficientVariation = 0.0000089;
		double coef = meters * coefficientVariation;
		double divLat = Math.cos(Math.toRadians(geolocation.getLatitude()));

		Geolocation ne = new Geolocation(geolocation.getLatitude() + coef, geolocation.getLongitude() + coef / divLat);
		Geolocation se = new Geolocation(geolocation.getLatitude() - coef, geolocation.getLongitude() + coef / divLat);
		Geolocation sw = new Geolocation(geolocation.getLatitude() - coef, geolocation.getLongitude() - coef / divLat);
		Geolocation nw = new Geolocation(geolocation.getLatitude() + coef, geolocation.getLongitude() - coef / divLat);
		squarePoints.add(ne);
		squarePoints.add(se);
		squarePoints.add(sw);
		squarePoints.add(nw);
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
	 * Algorithm using the 'haversine' formula to calculate the distance between two
	 * latitude/longitude points
	 * 
	 * @see      <a href="https://en.wikipedia.org/wiki/Haversine_formula">Haversine
	 *           Formula</a>
	 * @see      <a href="http://www.movable-type.co.uk/scripts/latlong.html">
	 * 			 great-circle distance between two points</a>
	 * @param p1 Geolocation object with latitude/longitude that represent the point p1
	 * @param p2 Geolocation object with latitude/longitude that represent the point p2
	 * @return   return a value double which represent distance in meters between 
	 *           two geolocation points.
	 */
	private double calculatePoint(Geolocation p1, Geolocation p2) {
		int r = 6378137; // Earth’s mean radius in meter
		double dLat = Math.toRadians(p2.getLatitude() - p1.getLatitude());
		double dLong = Math.toRadians(p2.getLongitude() - p1.getLongitude());
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(p1.getLatitude()) * Math.cos(Math.toRadians(p2.getLatitude())))
						* Math.sin(dLong / 2) * Math.sin(dLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = r * c;
		return d; // returns the distance in meters
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
	 * @param geo Is a Geolocation object that has a latitude and longitude
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
		for (Geolocation g : squarePoints) {
			System.out.println(g.getLatitude() + "," + g.getLongitude());
		}
	}

	public void printDistances() {
		for (Geolocation g : squarePoints) {
			System.out.println(calculatePoint(geolocation, g));
		}
	}
}
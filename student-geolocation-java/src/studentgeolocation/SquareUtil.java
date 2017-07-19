package studentgeolocation;

import java.util.List;

final public class SquareUtil {
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
	public double calculatePoint(Geolocation p1, Geolocation p2) {
		int r = 6378137; // Earth’s mean radius in meter
		double dLat = Math.toRadians(p2.getLatitude() - p1.getLatitude());
		double dLong = Math.toRadians(p2.getLongitude() - p1.getLongitude());
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(p1.getLatitude()) * Math.cos(Math.toRadians(p2.getLatitude())))
						* Math.sin(dLong / 2) * Math.sin(dLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = r * c;
		return d;
	}
	
	public void printSquarePoints(List<Geolocation> squarePoints) {
		for (Geolocation g : squarePoints) {
			System.out.println(g.getLatitude() + "," + g.getLongitude());
		}
	}

	public void printDistances(List<Geolocation> squarePoints, Geolocation geolocation) {
		for (Geolocation g : squarePoints) {
			System.out.println(calculatePoint(geolocation, g));
		}
	}
}

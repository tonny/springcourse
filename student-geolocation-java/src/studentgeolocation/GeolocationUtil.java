package studentgeolocation;

final public class GeolocationUtil {
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
	public double distanceBetweenTwoGeolocationPosition(Geolocation p1, Geolocation p2) {
		int radiusEarthInMetters = 6378137;
		double distanceLatitude = Math.toRadians(p2.getLatitude() - p1.getLatitude());
		double distanceLongitude = Math.toRadians(p2.getLongitude() - p1.getLongitude());
		double squareOfHalfTheChordLength = Math.sin(distanceLatitude / 2) * Math.sin(distanceLatitude / 2)
				+ Math.cos(Math.toRadians(p1.getLatitude()) * Math.cos(Math.toRadians(p2.getLatitude())))
						* Math.sin(distanceLongitude / 2) * Math.sin(distanceLongitude / 2);
		double angularDistanceInRadians = 2 * Math.atan2(Math.sqrt(squareOfHalfTheChordLength), Math.sqrt(1 - squareOfHalfTheChordLength));
		double distance = radiusEarthInMetters * angularDistanceInRadians;
		return distance;
	}
	
}

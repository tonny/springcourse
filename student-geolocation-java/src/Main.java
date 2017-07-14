import earth.Earth;
/**
 * Program to find if a group of student are inside a course in base his geolocation.
 * @author Antonio Mamani
 * @version 11/07/2017
 */
public class Main {

	public static void main(String[] args) {
		Earth earth = new Earth();
		System.out.println("First example Students founds:");
		earth.exampleSimulationOne();
	 	System.out.println("Second example students founds:");
	 	earth.exampleSimulationTwo();
	}
}

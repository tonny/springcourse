package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import studentgeolocation.ClassRoom;
import studentgeolocation.GeolocationSimulation;
import studentgeolocation.Student;

public class GeolocationSimulationTest {

	GeolocationSimulation earth = new GeolocationSimulation();

	@Test
	public void testExampleOneIfTheStudentsFoundInClassesIsEqualToThree() {
		List<Student> students = new ArrayList<>(Arrays.asList(
				new Student("John Wilson", 34.069149, -118.442639),
				new Student("Jane Graham", 34.069601, -118.441862),
				new Student("Pam Bam", 34.071513, -118.441181)
				));
		
		List<ClassRoom> classRooms = new ArrayList<>(Arrays.asList(
				new ClassRoom("Principles of computational", 34.069140, -118.442689),
				new ClassRoom("Sedimentary Petrology", 34.069585, -118.441878),
				new ClassRoom("Introductory Psychobiology", 34.069742, 118.441312),
				new ClassRoom("Art of Listening", 34.070223, -118.440193),
				new ClassRoom("Art Hitory", 34.071528, -118.441211)
				));

		List<Student> studentsFound = earth.studentsInClasses(students, classRooms);
		
		assertEquals("Should be 3", 3, studentsFound.size());
	}

	@Test
	public void testExampleTwoIfTheStudentsFoundInClassesIsEqualToThree() {
		List<Student> students = new ArrayList<>(Arrays.asList(
				new Student("John Wilson", 34.069849, -118.443539),
				new Student("Jane Graham", 34.069901, -118.441562),
				new Student("Pam Bam", 34.071523, -118.441171)
				));
		
		List<ClassRoom> classRooms = new ArrayList<>(Arrays.asList(
				new ClassRoom("Principles of computational", 34.069140, -118.442689),
				new ClassRoom("Sedimentary Petrology", 34.069585, -118.441878),
				new ClassRoom("Introductory Psychobiology", 34.069742, -118.441312),
				new ClassRoom("Art of Listening", 34.070223, -118.440193),
				new ClassRoom("Art Hitory", 34.071528, -118.441211)
				));

		List<Student> studentsFound = earth.studentsInClasses(students, classRooms);
		
		assertEquals("Should be 1", 1, studentsFound.size());
	}

}

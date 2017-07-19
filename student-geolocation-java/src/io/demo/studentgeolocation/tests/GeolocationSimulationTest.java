package io.demo.studentgeolocation.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.demo.studentgeolocation.classroom.ClassRoom;
import io.demo.studentgeolocation.simulation.GeolocationSimulation;
import io.demo.studentgeolocation.student.Student;

public class GeolocationSimulationTest {

	GeolocationSimulation earth = new GeolocationSimulation();

	@Test
	public void testExampleOneIfTheStudentsFoundInClassesIsEqualToThree() {
		List<Student> students = new ArrayList<Student>();
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();

		ClassRoom engineering = new ClassRoom("Principles of computational", 34.069140, -118.442689);
		ClassRoom geology = new ClassRoom("Sedimentary Petrology", 34.069585, -118.441878);
		ClassRoom psychology = new ClassRoom("Introductory Psychobiology", 34.069742, 118.441312);
		ClassRoom music = new ClassRoom("Art of Listening", 34.070223, -118.440193);
		ClassRoom humanities = new ClassRoom("Art Hitory", 34.071528, -118.441211);

		classRooms.add(humanities);
		classRooms.add(geology);
		classRooms.add(engineering);
		classRooms.add(music);
		classRooms.add(psychology);

		Student john = new Student("John Wilson", 34.069149, -118.442639);
		// engineering
		Student jane = new Student("Jane Graham", 34.069601, -118.441862);
		// geology
		Student pam = new Student("Pam Bam", 34.071513, -118.441181);
		// humanities

		students.add(john);
		students.add(jane);
		students.add(pam);
		List<Student> studentsFound = earth.studentsInClasses(students, classRooms);
		assertEquals("Should be 3", 3, studentsFound.size());
	}

	@Test
	public void testExampleTwoIfTheStudentsFoundInClassesIsEqualToThree() {
		List<Student> students = new ArrayList<Student>();
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();

		ClassRoom engineering = new ClassRoom("Principles of computational", 34.069140, -118.442689);
		ClassRoom geology = new ClassRoom("Sedimentary Petrology", 34.069585, -118.441878);
		ClassRoom psychology = new ClassRoom("Introductory Psychobiology", 34.069742, -118.441312);
		ClassRoom music = new ClassRoom("Art of Listening", 34.070223, -118.440193);
		ClassRoom humanities = new ClassRoom("Art Hitory", 34.071528, -118.441211);

		classRooms.add(humanities);
		classRooms.add(geology);
		classRooms.add(engineering);
		classRooms.add(music);
		classRooms.add(psychology);

		Student john = new Student("John Wilson", 34.069849, -118.443539);
		Student jane = new Student("Jane Graham", 34.069901, -118.441562);
		Student pam = new Student("Pam Bam", 34.071523, -118.441171);

		students.add(pam);
		students.add(jane);
		students.add(john);
		List<Student> studentsFound = earth.studentsInClasses(students, classRooms);
		assertEquals("Should be 1", 1, studentsFound.size());
	}

}

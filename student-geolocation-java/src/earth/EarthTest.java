package earth;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EarthTest {

	Earth earth = new Earth();
	
	@Test
	public void testExampleOneIfTheStudentsFoundInClassesIsEqualToThree() {
		List<Student> students = new ArrayList<Student>();
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
		
		ClassRoom engineering_classroom = new ClassRoom("Principles of computational geo-location analysis",34.069140,-118.442689);
		ClassRoom geology_classroom = new ClassRoom("Sedimentary Petrology",34.069585,-118.441878);
		ClassRoom psychology_classroom = new ClassRoom("Introductory Psychobiology",34.069742,118.441312);
		ClassRoom music_classroom = new ClassRoom("Art of Listening",34.070223,-118.440193);
		ClassRoom humanities_classroom = new ClassRoom("Art Hitory",34.071528,-118.441211);
		
		classRooms.add(humanities_classroom);
		classRooms.add(geology_classroom);
		classRooms.add(engineering_classroom);
		classRooms.add(music_classroom);
		classRooms.add(psychology_classroom);
		
		Student john_student = new Student("John Wilson", 34.069149, -118.442639);
		//engineering
		Student	jane_student = new Student("Jane Graham", 34.069601, -118.441862);
		//geology
		Student pam_student = new Student( "Pam Bam", 34.071513, -118.441181);
		//humanities
		
		students.add(john_student);
		students.add(jane_student);
		students.add(pam_student);
		List<Student> studentsFound = earth.studentsInClasses(students,classRooms);
		assertEquals("Should be 3", 3, studentsFound.size());
	}
	
	@Test
	public void testExampleTwoIfTheStudentsFoundInClassesIsEqualToThree() {
		List<Student> students = new ArrayList<Student> ();
		List<ClassRoom> classRooms = new ArrayList<ClassRoom> ();
		
		ClassRoom engineering_classroom = new ClassRoom ("Principles of computational geo-location analysis",34.069140,-118.442689);
		ClassRoom geology_classroom = new ClassRoom ("Sedimentary Petrology",34.069585,-118.441878);
		ClassRoom psychology_classroom = new ClassRoom ("Introductory Psychobiology", 34.069742, -118.441312);
		ClassRoom music_classroom = new ClassRoom ("Art of Listening", 34.070223, -118.440193);
		ClassRoom humanities_classroom = new ClassRoom ("Art Hitory", 34.071528, -118.441211);
		
		classRooms.add(humanities_classroom);
		classRooms.add(geology_classroom);
		classRooms.add(engineering_classroom);
		classRooms.add(music_classroom);
		classRooms.add(psychology_classroom);
		
		Student john_student = new Student("John Wilson", 34.069849, -118.443539);
		Student	jane_student = new Student("Jane Graham", 34.069901, -118.441562);
		Student pam_student = new Student("Pam Bam", 34.071523, -118.441171);
		
		students.add(pam_student);
		students.add(jane_student);
		students.add(john_student);
		List<Student> studentsFound = earth.studentsInClasses(students,classRooms);
		assertEquals("Should be 1", 1, studentsFound.size());
	}

}

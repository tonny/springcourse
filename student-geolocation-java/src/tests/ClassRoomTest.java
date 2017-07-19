package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import studentgeolocation.ClassRoom;
import studentgeolocation.Student;

public class ClassRoomTest {

	ClassRoom programming = new ClassRoom("Programming", -17.3974152, -66.1733624);
	Student johnStudent = new Student("John Wilson", 34.069849, -118.443539);
	Student janeStudent = new Student("Jane Graham", -17.3974152, -66.1733624);

	@Test
	public void testIsStudentOutsideClassRoom() {
		assertFalse("Is outsie", programming.isStudentInClassRoom(johnStudent.getPosition()));
	}

	@Test
	public void testStudentInsideClassRoom() {
		assertTrue("Is inside", programming.isStudentInClassRoom(janeStudent.getPosition()));
	}

}

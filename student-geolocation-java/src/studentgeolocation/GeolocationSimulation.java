package studentgeolocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeolocationSimulation {

	public GeolocationSimulation() {

	}

	/**
	 * Function to verify if a bunch of students are inside of a list of courses
	 * 
	 * @param students   <code>List<Student></code> students list to be searching inside 
	 *   				 of list a classrooms. 
	 * @param classRooms <code>List<ClassRoom></code> classrooms list to verify if a students
	 *                   are inside.   
	 * @return           <code>List<Student></code> a list with all students found 
	 * 					 inside a course.
	 */
	public List<Student> studentsInClasses(List<Student> students, List<ClassRoom> classRooms) {
		List<Student> studentsFound = new ArrayList<>();
		for (ClassRoom classRoom : classRooms) {
			for (Student student : students) {
				if (classRoom.isStudentInClassRoom(student.getPosition())) {
					studentsFound.add(student);
				}
			}
		}
		return studentsFound;
	}

	public void printStudentsList(List<Student> students) {
		for (Student s : students) {
			System.out.println("name:" + s.getName() + " , lat:" + s.getPosition().getLatitude() + " ,long:"
					+ s.getPosition().getLongitude());
		}
	}

	public void exampleSimulationOne() {
		List<Student> students = new ArrayList<>(Arrays.asList(
				new Student("John Wilson", 34.069149, -118.442639), 
				new Student("Jane Graham", 34.069601, -118.441862),
				new Student("Pam Bam", 34.071513, -118.441181)));

		List<ClassRoom> classRooms = new ArrayList<>(Arrays.asList(
				new ClassRoom("Principles of computational", 34.069140, -118.442689),
				new ClassRoom("Sedimentary Petrology", 34.069585, -118.441878),
				new ClassRoom("Introductory Psychobiology", 34.069742, 118.441312),
				new ClassRoom("Art of Listening", 34.070223, -118.440193),
				new ClassRoom("Art Hitory", 34.071528, -118.441211)));

		printStudentsList(studentsInClasses(students, classRooms));
	}

	public void exampleSimulationTwo() {
		List<Student> students = new ArrayList<>(Arrays.asList(
				new Student("John Wilson", 34.069849, -118.443539),
				new Student("Jane Graham", 34.069901, -118.441562),
				new Student("Pam Bam", 34.071523, -118.441171)));
		
		List<ClassRoom> classRooms = new ArrayList<>(Arrays.asList(
				new ClassRoom("Principles of computational", 34.069140, -118.442689),
				new ClassRoom("Sedimentary Petrology", 34.069585, -118.441878),
				new ClassRoom("Introductory Psychobiology", 34.069742, -118.441312),
				new ClassRoom("Art of Listening", 34.070223, -118.440193),
				new ClassRoom("Art Hitory", 34.071528, -118.441211)));

		printStudentsList(studentsInClasses(students, classRooms));
	}

}

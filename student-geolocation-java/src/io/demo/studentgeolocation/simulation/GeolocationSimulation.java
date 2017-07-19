package io.demo.studentgeolocation.simulation;

import java.util.ArrayList;
import java.util.List;

import io.demo.studentgeolocation.classroom.ClassRoom;
import io.demo.studentgeolocation.student.Student;

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
		List<Student> studentsFound = new ArrayList<Student>();
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
		Student jane = new Student("Jane Graham", 34.069601, -118.441862);
		Student pam = new Student("Pam Bam", 34.071513, -118.441181);

		students.add(john);
		students.add(jane);
		students.add(pam);

		printStudentsList(studentsInClasses(students, classRooms));
	}

	public void exampleSimulationTwo() {
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

		Student john_student = new Student("John Wilson", 34.069849, -118.443539);
		Student jane_student = new Student("Jane Graham", 34.069901, -118.441562);
		Student pam_student = new Student("Pam Bam", 34.071523, -118.441171);

		students.add(pam_student);
		students.add(jane_student);
		students.add(john_student);

		printStudentsList(studentsInClasses(students, classRooms));
	}

}

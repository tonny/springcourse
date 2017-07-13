package earth;
import java.util.ArrayList;
import java.util.List;

public class Earth {
	
	
	public Earth() {
	
	}
	/**
	 * Function to verify if a bunch of students is inside of a list of courses 
	 * @param students 
	 * @param classRooms
	 * @return a list with all students found inside a course 
	 */
	public List<Student> studentsInClasses(List<Student> students, List<ClassRoom> classRooms) {
		List<Student> studentsFound = new ArrayList<Student>();
		for(ClassRoom classRoom: classRooms) {
			for(Student student: students) {
				if(classRoom.isStudentInClassRoom(student.getPosition())) {
					studentsFound.add(student);
				}
			}
		}
		return studentsFound;
	}
	
	public void printStudentsList(List<Student> students) {
		for(Student s:students) {
			System.out.println("name:"+s.getName()+" , lat:"+s.getPosition().getLatitude()+" ,long:"+s.getPosition().getLongitude());
		}
	}
	
	public void exampleSimulationOne() {
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
		Student	jane_student = new Student("Jane Graham", 34.069601, -118.441862);
		Student pam_student = new Student( "Pam Bam", 34.071513, -118.441181);
		
		students.add(john_student);
		students.add(jane_student);
		students.add(pam_student);
		
		printStudentsList(studentsInClasses(students,classRooms));
	}
	
	public void exampleSimulationTwo() {
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
		
		printStudentsList(studentsInClasses(students,classRooms));
	}
	
	
}

package io.demo.springcourse.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.demo.springcourse.models.domain.Course;
import io.demo.springcourse.models.domain.Student;

@Service
public class CourseService {
	
	private List<Course> courses = new ArrayList<Course>(Arrays.asList(
			new Course("1","Oruro","It has capacity for 10 students"),
			new Course("2","La Paz","It has capacity for 100 students "),
			new Course("3","Cochabamba","It has capacity for 1000 students and also wifi")
			));
	
	public List<Course> getAllCourses() {
		return courses;
	}
	
	public Course getCourse(String code) {
		return courses.stream().filter(course->course.getCode().equals(code)).findFirst().get();
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void updateCourse(Course course, String code) {
		for(int i =0 ; i <courses.size(); i++) {
			Course c = courses.get(i);
			if(c.getCode().equals(code)) {
				if(course.getStudents() == null) {
					course.setStudents(c.getStudents());
				}
				courses.set(i, course);
				break;
			}
		}
	}

	public void deleteCourse(String code) {
		courses.removeIf(course-> course.getCode().equals(code));
	}
	
	public void addStudent(Student student, String courseCode) {
		Course course = getCourse(courseCode);
		if(course != null) {
			course.addStudent(student);
		}
	}

	public List<Student> getStudents(String code) {
		Course c = getCourse(code);
		return c.getStudents();
	}

	public boolean unregisterStudent(String code, String id) {
		boolean success = false;
		Course c = getCourse(code);
		if(c != null)
			success = c.getStudents().removeIf(student -> student.getId().equals(id));
		return success;
	}
}

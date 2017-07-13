package io.demo.springcourse.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.demo.springcourse.models.domain.Student;

@Service
public class StudentService {

	private List<Student> students = new ArrayList<Student>(Arrays.asList(
			new Student("1","Antonio","Mamani"),
			new Student("2","Raul","Lopez"),
			new Student("3","Carlos","Garcia")
			));
	
	public List<Student> getAllStudents() {
		return students;
	}
	
	public Student getStudent(String id) {
		return students.stream().filter(s->s.getId().equals(id)).findFirst().get();
	}

	public boolean addStudent(Student student) {
		return students.add(student);
	}

	public void updateStudent(Student student, String id) {
		for(int i =0 ; i <students.size(); i++) {
			Student s = students.get(i);
			if(s.getId().equals(id)) {
				students.set(i, student);
				break;
			}
		}
	}

	public void deleteStudent(String id) {
		students.removeIf(s-> s.getId().equals(id));
	}
	

}

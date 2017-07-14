package io.demo.springcourse.models.domain;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String code;
	private String title;
	private String description;
	private List<Student> students;
	
	public Course() {}
	
	public Course(String code, String title, String description) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
		students = new ArrayList<Student>();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Student> getStudents (){
		return students;
	}
	
	public void setStudents (List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
}

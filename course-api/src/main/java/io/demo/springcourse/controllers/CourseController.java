package io.demo.springcourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.demo.springcourse.models.domain.Course;
import io.demo.springcourse.models.domain.Student;
import io.demo.springcourse.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/courses/{code}")
	public Course getCourse(@PathVariable String code) {
		return courseService.getCourse(code);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/courses")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/courses/{code}")
	public void updateCourse(@RequestBody Course course, @PathVariable String code) {
		courseService.updateCourse(course,code);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{code}")
	public void deleteCourse(@PathVariable String code) {
		courseService.deleteCourse(code);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{code}/student")
	public void addStudent(@RequestBody Student student, @PathVariable String code) {
		courseService.addStudent(student, code);
	}
	
	@RequestMapping("/courses/{code}/student")
	public List<Student> addStudents(@PathVariable String code) {
		return courseService.getStudents(code);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{code}/student/{id}")
	public boolean unregisterStudent(@PathVariable String code, @PathVariable String id) {
		return courseService.unregisterStudent(code,id);
	}
}

package io.demo.springcourse.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.demo.springcourse.controllers.StudentController;
import io.demo.springcourse.models.domain.Student;
import io.demo.springcourse.services.StudentService;

public class StudentControllerTest {

	private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(studentController)
                .build();
    }
	
	@Test
	public void testIfWeGetAllStudents() throws Exception {
		List<Student> students = new ArrayList<Student>(Arrays.asList(
				new Student("1","Antonio","Mamani"),
				new Student("2","Raul","Lopez"),
				new Student("3","Carlos","Garcia")
				));
	    when(studentService.getAllStudents()).thenReturn(students);
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	    		.get("/students")
	    		.accept(MediaType.APPLICATION_JSON);
	    
	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	    
		String expected = "[{\"id\":\"1\",\"firstName\":\"Antonio\",\"lastName\":\"Mamani\"},{\"id\":\"2\",\"firstName\":\"Raul\",\"lastName\":\"Lopez\"},{\"id\":\"3\",\"firstName\":\"Carlos\",\"lastName\":\"Garcia\"}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void testIfWecreateAStudent() throws Exception {
		Student mockStudent = new Student("5", "Pepe", "Mujica");
		String exampleStudentJson = "{\"id\":\"4\",\"fistName\":\"Jorge\",\"lastName\":\"Lopez\"}";

		// studentService.addStudent to respond back with true
		when(studentService.addStudent(mockStudent)).thenReturn(true);

		// Send student as body to /students
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students")
				.accept(MediaType.APPLICATION_JSON).content(exampleStudentJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}

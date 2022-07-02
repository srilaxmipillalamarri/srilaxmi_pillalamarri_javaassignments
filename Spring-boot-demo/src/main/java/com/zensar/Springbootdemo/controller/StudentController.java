package com.zensar.Springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Springbootdemo.controller.entity.Student;
import com.zensar.Springbootdemo.dto.StudentDto;
import com.zensar.Springbootdemo.service.StudentService;

@RestController
@RequestMapping(value = "/student-api", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {

	@Autowired
	private StudentService studentService;

	// http://localhost:8080/students/1001 GET
	// @RequestMapping(value = "/students/{studentId}",method=RequestMethod.GET)
	@GetMapping(value = "/students/{stdId}")
	//public StudentDto getStudent(@PathVariable("stdId") int stdId) {
	public ResponseEntity<StudentDto> getStudent(@PathVariable("stdId") int stdId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(stdId),HttpStatus.OK);
	}

//@RequestMapping(value = { "/students", "/listOfStudents" },method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listOfStudents" })
	//public List<StudentDto> getAllStudents() {
		public ResponseEntity<List<StudentDto>> getAllStudents(@RequestParam(value="pageNumber",required=false,defaultValue="0")int pageNumber,@RequestParam(value="pageSize",required = false,defaultValue = "3")int pageSize) {
		//return studentService.getAllStudents();
		return new ResponseEntity<List<StudentDto>>(studentService.getAllStudents(pageNumber,pageSize),HttpStatus.OK);
	}

//@RequestMapping(value="/students",method=RequestMethod.POST)
	@PostMapping(value = "/students")

	//public StudentDto insertStudent(@RequestBody StudentDto studentDto) {
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {

		//return studentService.insertStudent(studentDto);
		return new  ResponseEntity<StudentDto>(studentService.insertStudent(studentDto),HttpStatus.CREATED);
		/* public void insertStudent(@RequestBody Student student) { */

		/* public void insertStudent(@RequestBody StudentDto studentDto) { */

		/* public Student insertStudent(@RequestBody StudentDto studentDto) { */

		/* studentService.insertStudent(studentDto); */

		// System.out.println("HI");
	}

//@RequestMapping(value="/students/{stdId}",method=RequestMethod.PUT)
	@PutMapping(value = "/students/{stdId}")
	//public void updateStudent(@PathVariable("stdId") int stdId, @RequestBody StudentDto studentDto) {
		public ResponseEntity<String> updateStudent(@PathVariable("stdId") int stdId, @RequestBody StudentDto studentDto) {
		return new ResponseEntity<String>("student upadated successfully",HttpStatus.OK);
	}

//http://localhost:8080/students -> Delete
//@RequestMapping(value="/students/{stdId}",method=RequestMethod.DELETE)
	@DeleteMapping(value = "/students/{stdId}")
	// public void deleteStudent(@PathVariable("stdId") int stdId) {
	public ResponseEntity deleteStudent(@PathVariable("stdId") int stdId) {
		studentService.deleteStudent(stdId);
		return new ResponseEntity<String>("student deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value = "/students/stdName/{stdName}")
	public List<Student> getByStdName(@PathVariable("stdName")String stdName){
	//public ResponseEntity<List<StudentDto>> getByStdName(@PathVariable("stdName") String stdName) {

		return studentService.getByStdName(stdName);
		// return studentService.findByStdName(stdName);

		// return studentService.queryByStdName(stdName); 
		//return studentService.searchByStdName( stdName);
		//return new ResponseEntity<List<StudentDto>>(studentService.getByStdName(stdName),HttpStatus.OK);

	}

	@GetMapping(value = "/students/stdName/{stdName}/{stdAge}")
	 public List<Student> findByStdNameAndStdAge(@PathVariable("stdName") String stdName,@PathVariable("stdAge") int stdAge) {
	//public ResponseEntity<List<StudentDto>> findByStdNameAndStdAge(@PathVariable("stdName") String stdName,@PathVariable("stdAge") int stdAge) {
		//return new ResponseEntity<List<StudentDto>>(studentService.findByStdNameAndStdAge(stdName, stdAge),HttpStatus.OK);
			 return studentService.findByStdNameAndStdAge(stdName, stdAge);
	}

}

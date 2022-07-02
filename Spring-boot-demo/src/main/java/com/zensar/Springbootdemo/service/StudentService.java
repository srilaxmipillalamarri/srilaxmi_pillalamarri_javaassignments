package com.zensar.Springbootdemo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.Springbootdemo.controller.entity.Student;
import com.zensar.Springbootdemo.dto.StudentDto;

public interface StudentService {

	public StudentDto getStudent(int stdId);

	public List<StudentDto> getAllStudents();

	// public StudentDto insertStudent(StudentDto student);
	public StudentDto insertStudent(StudentDto studentDto);
	

	// public StudentDto updateStudent(int stdId, StudentDto student);
	public void updateStudent(int stdId, StudentDto student);

	public void deleteStudent(int stdId);

	// public List<Student> getByStdName(String stdName);

	// public List<Student> findByStdName(String stdName);
	// public List<Student> queryByStdName(String stdName);
	// public List<Student> searchByStdName(String stdName);
	public List<Student> getByStdName(String stdName);

	public List<Student> findByStdNameAndStdAge(String stdName, int stdAge);

	public List<StudentDto> getAllStudents(int pageNumber, int pageSize);

	
	//public ResponseEntity<List<StudentDto>> getByStdName( String stdName);
	
	//public ResponseEntity<List<StudentDto>> findByStdNameAndStdAge(String stdName,int stdAge);
	
}

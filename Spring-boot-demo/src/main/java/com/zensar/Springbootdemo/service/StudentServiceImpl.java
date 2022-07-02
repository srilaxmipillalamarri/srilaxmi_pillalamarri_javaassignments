package com.zensar.Springbootdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.Springbootdemo.controller.entity.Student;
import com.zensar.Springbootdemo.dto.StudentDto;
import com.zensar.Springbootdemo.repository.StudentRepository;
import com.zensar.Springbootdemo.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	/* public Student getStudent(int stdId) { */
	public StudentDto getStudent(int stdId) {
		Student student = studentRepository.findById(stdId).get();
//StudentDto dto =mapToDto(student);

		return modelMapper.map(student, StudentDto.class);
//return dto;

		/*
		 * return studentRepository.findById(studentId).get(); StudentDto dto=new
		 * StudentDto(); dto.setStudentId(student.getStudentId());
		 * dto.setStdName(student.getStdName()); dto.setStdAge(student.getStdAge());
		 * return dto;
		 */

	}

	@Override
	public List<StudentDto> getAllStudents() {
		/* return studentRepository.findAll(); */

		List<Student> listOfStudents = studentRepository.findAll();
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		for (Student student : listOfStudents) {
//listOfStudentsDto.add(mapToDto(student));
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentsDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {

		/*
		 * Student student=new Student(); student.setStdId(student.getStdId());
		 * student.setStdName(student.getStudentName());
		 * student.setStdAge(student.getStudentAge());
		 */

//Student student=mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student insertedStudent = studentRepository.save(student);
//StudentDto mapToDto=mapToDto(insertedStudent);
		return modelMapper.map(insertedStudent, StudentDto.class);
//return mapToDto;

		/*
		 * StudentDto dto=new StudentDto(); dto.setStdId(insertedStudent.getStdId());
		 * dto.setStdName(insertedStudent.getStdName());
		 * dto.setStdAge(insertedStudent.getStdAge()); return dto;
		 */

	}

	@Override
	public void updateStudent(int stdId, StudentDto studentDto) {
		/*
		 * Student student=new Student(); student.setStdId(student.getStdId());
		 * student.setStdName(student.getStdName());
		 * student.setStdAge(student.getStdAge());
		 */
//Student student=mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int stdId) {
		studentRepository.deleteById(stdId);

	}

	@Override
	public List<Student> getByStdName(String stdName) {

		// public ResponseEntity<List<StudentDto>> getByStdName(String stdName){
		// return studentRepository.test(stdName),HttpStatus.OK);

		// public List<Student> findByStdName(String stdName){
		// public List<Student> queryByStdName(String stdName){
		// public List<Student> searchByStdName(String stdName){
		return studentRepository.test(stdName);
	}

	

	@Override
	public List<Student> findByStdNameAndStdAge(String stdName, int stdAge) {
		// public ResponseEntity<List<StudentDto>> findByStdNameAndStdAge(String
		// stdName,int stdAge){
		// return studentRepository.test1(stdName, stdAge),HttpStatus.OK);
		return studentRepository.test1(stdName, stdAge);
	}

	@Override
	public List<StudentDto> getAllStudents(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by("stdName")));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"stdName" )));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.ASC,"stdName" )));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.ASC,"stdName"));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.DESC,"stdName"));
		Page<Student> findAll = studentRepository.findAll(PageRequest.of(0,3, Sort.by(Direction.DESC, "stdName")));
		List<Student> content = findAll.getContent();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		for(Student student:content) 
			listOfStudentDto.add(modelMapper.map(student,StudentDto.class));
		return listOfStudentDto;
	}
	}


/*
 * public StudentDto mapToDto(Student student) { StudentDto dto=new
 * StudentDto(); dto.setStdId(student.getStdId());
 * dto.setStdName(student.getStdName()); dto.setStdAge(student.getStdAge());
 * return dto; }
 * 
 * 
 * public Student mapToEntity(StudentDto studentDto) {
 * 
 * Student student=new Student(); student.setStdId(student.getStdId());
 * student.setStdName(student.getStdName());
 * student.setStdAge(student.getStdAge()); return student; }
 */

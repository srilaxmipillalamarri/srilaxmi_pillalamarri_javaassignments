package com.zensar.Springbootdemo.repository;



import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.Springbootdemo.controller.entity.Student;
import com.zensar.Springbootdemo.dto.StudentDto;



public interface StudentRepository extends JpaRepository<Student,Integer>{
	List<Student> findByStdName(String stdName);
	List<Student> findByStdNameOrStdAge(String stdName, int stdAge);
	//ListStudent> findByStdNameAndStdAge(String stdName, int stdAge);
	List<Student> findByStdNameOrderByStdAge(String stdName);
	
	//List<Student> test( String stdName);
	//@Query(value = "from student s where s.StdName=:name")
	@Query(value = "select * from student s where s.std_Name=:name",nativeQuery=true)
	List<Student> test(@Param("name") String stdName);
	
	//List<Student> test1( String stdName,int stdSge);
	//@Query(value = "from student s where s.stdName=:name and s.stdAge=:age")
	@Query(value = "select * from student s where s.std_name=:name and s.std_age=:age",nativeQuery=true)
	List<Student> test1(@Param("name")String StdName,@Param("age")int stdAge);
}
	 

	
	 

	


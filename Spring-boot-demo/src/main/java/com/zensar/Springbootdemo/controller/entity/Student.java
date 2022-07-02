package com.zensar.Springbootdemo.controller.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQuery;






@Entity
//@NamedQuery(name="Student.test",query= "from Student s where s.stdName=?1")
//@NamedQuery(name="Student.test1",query= "from Student s where s.stdName=?1 and s.stdAge=?2")
public class Student {
	@Id
	private int stdId;
	private String stdName;
	private int stdAge;
	public Student() {
		super();
	}
	public Student(int stdId, String stdName, int stdAge) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdAge = stdAge;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getStdAge() {
		return stdAge;
	}
	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdage=" + stdAge + "]";
	}
	
	
	
}

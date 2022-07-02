
package com.zensar.Springbootdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;



public class StudentDto {
	private int stdId;
	private String stdName;
	private int stdAge;
	public StudentDto() {
		super();
	}
	private StudentDto(int stdId, String stdName, int stdAge) {
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
		return "StudentDto [stdId=" + stdId + ", stdName=" + stdName + ", stdAge=" + stdAge + "]";
	}
	

}

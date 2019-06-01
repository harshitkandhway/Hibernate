package com.harshit.tutorial2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int studentId;
	private String studentName;
	@ManyToMany
	private List<Laptop> laptoplist;
	
	public List<Laptop> getLaptoplist() {
		return laptoplist;
	}
	public void setLaptoplist(List<Laptop> laptoplist) {
		this.laptoplist = laptoplist;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", laptoplist=" + laptoplist + "]";
	}
	
	
}

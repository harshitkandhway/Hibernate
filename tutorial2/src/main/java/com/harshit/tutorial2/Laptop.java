package com.harshit.tutorial2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Laptop{
	@Id
	private int laptopId;
	private String laptopName;
	private String laptopManufacturer;
	@ManyToMany(mappedBy = "laptoplist")
	private List<Student> stud;	
	public List<Student> getStud() {
		return stud;
	}
	public void setStud(List<Student> stud) {
		this.stud = stud;
	}
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public String getLaptopManufacturer() {
		return laptopManufacturer;
	}
	public void setLaptopManufacturer(String laptopManufacturer) {
		this.laptopManufacturer = laptopManufacturer;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopManufacturer="
				+ laptopManufacturer + ", stud=" + stud + "]";
	}
	
	
}
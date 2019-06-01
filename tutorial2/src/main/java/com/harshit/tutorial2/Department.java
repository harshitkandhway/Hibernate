package com.harshit.tutorial2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Department {
	@Id
	private int deptId;
	private String deptName;
	@OneToMany(mappedBy = "empDept")//,fetch = FetchType.EAGER)
	private List<Employee> emplist;
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", emplist=" + emplist + "]";
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	
}

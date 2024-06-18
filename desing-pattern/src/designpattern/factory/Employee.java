package designpattern.factory;

import java.util.List;
import java.util.Objects;

public class Employee {
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	enum DEPT {
		IT, HR, ADMIN

	}
	private String dept;
	
	private String name;
	private String id;
	private double salary;
	private List<Long> mobileNums;
	
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public List<Long> getMobileNums() {
		return mobileNums;
	}
	public void setMobileNums(List<Long> mobileNums) {
		this.mobileNums = mobileNums;
	}
	
}

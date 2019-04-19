package com.meek.donald;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer emplid;
	@NotNull
	private String name;
	@NotNull
	private String dept;
	private Integer emplsNum;
	@NotNull
	private String addr;
	@NotNull
	private Integer soch;
	
	public Integer getEmplid() {
		return emplid;
	}
	public void setEmplid(Integer emplid) {
		this.emplid = emplid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getEmplsNum() {
		return emplsNum;
	}
	public void setEmplsNum(Integer emplsNum) {
		this.emplsNum = emplsNum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getSoch() {
		return soch;
	}
	public void setSoch(Integer soch) {
		this.soch = soch;
	}
}

package com.app.student;

import java.io.Serializable;
import java.time.LocalDate;
public class Student implements Serializable {
    private int rollNo;
    private String name;
    private String email;
    private String password;
    private Subject subject;
    private LocalDate dob;
    private double mark;
    private static int cnt;
    
    public Student() {
		// TODO Auto-generated constructor stub
	}
    
    public Student(String email)
    {
    	this.email = email;
    }
	public Student(String name, String email, String password, Subject subject, LocalDate dob, double mark) {
		super();
		this.rollNo = ++cnt;
		this.name = name;
		this.email = email;
		this.password = password;
		this.subject = subject;
		this.dob = dob;
		this.mark = mark;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int id) {
		this.rollNo = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [RollNo=" + rollNo + ", name=" + name + ", email=" + email + ", password=" + password + ", subject="
				+ subject + ", dob=" + dob + ", mark=" + mark + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{	
		Student std = (Student)o;
		if(o instanceof Student)
		{
			return this.rollNo==std.rollNo;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return rollNo;
	}

    
    
}

package com.app.cricket;

public class Cricketer {
    private String name;
    private String email;
    private String phone;
    private int rating;
    private int age;
	public Cricketer(String name, String email, String phone, int rating, int age) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.rating = rating;
		this.age = age;
	}
	
	public Cricketer(String email) {
		super();
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", email=" + email + ", phone=" + phone + ", rating=" + rating + ", age="
				+ age + "]";
	}
    
    
    
    
}

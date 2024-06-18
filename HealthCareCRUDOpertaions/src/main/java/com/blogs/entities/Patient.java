package com.blogs.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="patients_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Patient extends BaseEntities {
	
	@Column(name="first_name" ,length=20)
	private String firstName;
	 @Column(name="last_name" ,length=20)
	private String lastName;
	 @Column(name="Email" ,length=20 ,unique = true)
	private String email;
	 @Column(name="ContactNo" ,length=20 ,unique = true)
	 private String phoneNo;
	
	private LocalDate dob;
	 
	
	@Column(name="Blood_Group" ,length=10)
	private String bloodGroup;
	

}

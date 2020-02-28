package com.xworkz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="modules_table")
@NamedQueries({@NamedQuery(name="fetchByemail",query="select sign from ModuleEntity sign where sign.email=email"),
@NamedQuery(name="fetchByEmailAndPassword",query="select sign from ModuleEntity sign where sign.email=:email and  sign.password=:password")})

public class ModuleEntity implements Serializable{
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name ="id")
	private int id;
	@Column(name ="userName")
	private String userName;
	@Column(name ="email")
	private String email;
	@Column(name ="phoneNumber")
	private long  phoneNumber;
	@Column(name ="password")
	private String password;
	@Column(name ="confirmPassword")
	private String confirmPassword;
	


	public ModuleEntity() {
		System.out.println("created\t"+this.getClass().getSimpleName());
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	@Override
	public String toString() {
		return "ModuleEntity [id=" + id + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

	

	
	
}

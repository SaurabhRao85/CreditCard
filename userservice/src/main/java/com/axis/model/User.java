package com.axis.model;

import java.sql.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="user")
public class User {

	
	private Long id;
	private String holderName;
	private int age;
	private Long phoneNumber;
    @JsonIgnore
    private String password;
    private String role;
    private String address;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private Timestamp createdAt;
    private Integer status;

  
    private CreditCard creditCard;
    
    
	    public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

		@JsonProperty
	    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss",timezone = "GMT+7")
	    public Timestamp getCreatedAt() {
	        return createdAt;
	    }

		public User() {
			super();
			
		}

		public User(Long id, String holderName, int age, Long phoneNumber, String password, String role,
				String address, String city, String state, String country, int pincode, Timestamp createdAt,
				Integer status) {
			super();
			this.id = id;
			this.holderName = holderName;
			this.age = age;
			this.phoneNumber = phoneNumber;
			this.password = password;
			this.role = role;
			this.address = address;
			this.city = city;
			this.state = state;
			this.country = country;
			this.pincode = pincode;
			this.createdAt = createdAt;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getHolderName() {
			return holderName;
		}

		public void setHolderName(String holderName) {
			this.holderName = holderName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getPincode() {
			return pincode;
		}

		public void setPincode(int postalcode) {
			this.pincode = postalcode;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}

		

	
}

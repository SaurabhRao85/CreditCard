package com.axis.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

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
    
    private CreditCardDto creditCardDto;
    

	public UserDto() {
		super();
		
	}
	public UserDto(Long id, String holderName, int age, Long phoneNumber, String password, String role,
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
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public CreditCardDto getCreditCardDto() {
		return creditCardDto;
	}
	public void setCreditCardDto(CreditCardDto creditCardDto) {
		this.creditCardDto = creditCardDto;
	}
	
    
    
}

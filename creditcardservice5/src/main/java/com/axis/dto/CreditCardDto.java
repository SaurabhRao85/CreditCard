package com.axis.dto;

import java.util.Date;

public class CreditCardDto {

	private long id;
	private String cardNumber;
	private String holderName;
	private String cardType;
	private Date expireDate;
	private String csv;
	private Double dailyLimit;
	private Boolean status;
	
	private UserDto userDto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public Double getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(Double dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	
	
	
}

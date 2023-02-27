package com.axis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.axis.dto.UserDto;

@Entity
@Table(name = "creditCards")
public class CreditCard {

	@Id
	@Column(name ="creditCard_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cardNumber;
	private String holderName;
	private String cardType;
	private Date expireDate;
	private String csv;
	private Double dailyLimit;
	private Boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private User user;

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCard(long id, String cardNumber, String holderName, String cardType, Date expireDate, String csv,
			Double dailyLimit, Boolean status) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.holderName = holderName;
		this.cardType = cardType;
		this.expireDate = expireDate;
		this.csv = csv;
		this.dailyLimit = dailyLimit;
		this.status = status;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
}

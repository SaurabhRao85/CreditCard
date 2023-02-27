package com.axis.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value ="CreditCardDailyLimitRequest")
public class CreditCardDailyLimitRequest {

	@Positive(message = "Id Must be positive")
	  @ApiModelProperty(value = "id  of creditcard", required = true)
	  private Long id;

	  @NotNull(message = "Phone Not Allow empty")
	  @ApiModelProperty(value = "Daily limit of creditcard", required = true, example = "1000.00")
	  private Double dailyLimit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(Double dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
	  
	  
}
